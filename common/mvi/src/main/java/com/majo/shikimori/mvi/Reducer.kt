package com.majo.shikimori.mvi

fun interface Reducer<InternalAction: Any, State: Any> {
    fun reduce(internalAction: InternalAction, previousState: State): State
}