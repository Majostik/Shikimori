package com.majo.shikimori.mvi

import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.AbstractFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart

@OptIn(FlowPreview::class)
class Feature<Action: Any, InternalAction: Any, State: Any, OneTimeEvent: Any> constructor(
    private val initialState: State,
    private val bootstrap: Bootstrap<InternalAction>,
    private val actor: Actor<Action, InternalAction, State>,
    private val eventProducer: OneTimeEventProducer<InternalAction, OneTimeEvent>,
    private val reducer: Reducer<InternalAction, State>
): AbstractFlow<State>(), FlowCollector<Action> {
    companion object {
        internal const val EVENTS_BUFFER = 16
        internal const val ACTIONS_BUFFER = 16
    }

    private val actionsFlow = MutableSharedFlow<Action>(replay = 0, ACTIONS_BUFFER, BufferOverflow.SUSPEND)
    private val eventsFlow = MutableSharedFlow<OneTimeEvent>(replay = 0, EVENTS_BUFFER, BufferOverflow.SUSPEND)

    val events: Flow<OneTimeEvent> = eventsFlow.asSharedFlow()

    var state = initialState
        private set

    private val stateFlow: Flow<State> =
        merge(
            observeBoostrap(),
            observeActor()
        )
            .onEach { internalAction ->
                produceEvent(internalAction)
            }
            .map { internalAction ->
                mapToState(internalAction)
            }
            .onStart {
                emit(state)
            }
            .distinctUntilChanged()

    private fun observeBoostrap(): Flow<InternalAction> {
        return bootstrap
            .produce()
    }

    private fun observeActor(): Flow<InternalAction> {
        return actionsFlow
            .processAction()
    }

    private fun Flow<Action>.processAction() = with(actor) { process { state } }

    private suspend fun produceEvent(internalAction: InternalAction) {
        val event = eventProducer.produce(internalAction)
        if (event != null) {
            eventsFlow.emit(event)
        }
    }

    private fun mapToState(internalAction: InternalAction): State {
        val newState = reducer.reduce(internalAction, state)
        state = newState
        return newState
    }

    suspend fun accept(action: Action) {
        actionsFlow.emit(action)
    }

    override suspend fun collectSafely(collector: FlowCollector<State>) {
        stateFlow.collect(collector)
    }

    override suspend fun emit(value: Action) {
        accept(value)
    }
}