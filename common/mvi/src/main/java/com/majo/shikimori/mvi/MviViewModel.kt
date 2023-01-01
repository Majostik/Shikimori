package com.majo.shikimori.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

abstract class MviViewModel<Action: Any, State: Any, OneTimeEvent: Any>(
    private val featureBuilder: FeatureBuilder<Action, *, State, OneTimeEvent>,
    private val sharingStateStrategy: SharingStarted = ConfigurationChangeSharingStrategy
): ViewModel() {

    private val feature by lazy {
        featureBuilder.build()
    }

    val state: StateFlow<State> = feature.stateIn(viewModelScope, sharingStateStrategy, feature.state)

    val events: Flow<OneTimeEvent> = feature.events

    open fun accept(action: Action) {
        viewModelScope.launch {
            feature.emit(action)
        }
    }

    suspend fun collectState(collector: FlowCollector<State>) {
        state.collect(collector)
    }

    suspend fun collectEvents(collector: FlowCollector<OneTimeEvent>) {
        feature.events.collect(collector)
    }
}