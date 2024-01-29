package com.majo.shikimori.mvi

fun interface OneTimeEventProducer<InternalAction : Any, OneTimeEvent : Any> {
    fun produce(internalAction: InternalAction): OneTimeEvent?
}
