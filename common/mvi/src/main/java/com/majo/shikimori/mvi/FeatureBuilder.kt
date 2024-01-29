package com.majo.shikimori.mvi

import kotlinx.coroutines.flow.emptyFlow

abstract class FeatureBuilder<Action : Any, InternalAction : Any, State : Any, OneTimeEvent : Any>(
    private val initialState: State,
    private val setupFunc: FeatureBuilder<Action, InternalAction, State, OneTimeEvent>.() -> Unit,
) {
    private var actor: Actor<Action, InternalAction, State> = Actor { _, _ -> emptyFlow() }
    private var eventProducer: OneTimeEventProducer<InternalAction, OneTimeEvent> = OneTimeEventProducer { null }
    private var reducer: Reducer<InternalAction, State> = Reducer { _, state -> state }

    fun withActor(actor: Actor<Action, InternalAction, State>) = apply {
        this.actor = actor
    }

    fun withEventReducer(eventProducer: OneTimeEventProducer<InternalAction, OneTimeEvent>) = apply {
        this.eventProducer = eventProducer
    }

    fun withReducer(reducer: Reducer<InternalAction, State>) = apply {
        this.reducer = reducer
    }

    fun build(
        restoredState: State? = null,
    ): Feature<Action, InternalAction, State, OneTimeEvent> {
        this.setupFunc()
        return Feature(
            initialState = restoredState ?: initialState,
            actor = actor,
            eventProducer = eventProducer,
            reducer = reducer,
        )
    }
}
