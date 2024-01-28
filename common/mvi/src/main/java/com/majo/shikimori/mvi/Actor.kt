package com.majo.shikimori.mvi

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapMerge

fun interface Actor<Action: Any, InternalAction: Any, State: Any> {

    fun process(action: Action, previousState: State): Flow<InternalAction>

    fun Flow<Action>.process(previousState: () -> State): Flow<InternalAction> =
        flatMapMerge { action -> process(action, previousState.invoke()) }
}