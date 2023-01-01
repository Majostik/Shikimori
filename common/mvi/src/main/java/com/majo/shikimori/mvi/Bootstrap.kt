package com.majo.shikimori.mvi

import kotlinx.coroutines.flow.Flow

fun interface Bootstrap<InternalAction: Any> {
    fun produce(): Flow<InternalAction>
}