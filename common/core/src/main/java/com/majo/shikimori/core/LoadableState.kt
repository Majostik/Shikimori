package com.majo.shikimori.core

sealed class LoadableState<T> {

    class Loading<T>() : LoadableState<T>()

    data class Loaded<T>(val data: T) : LoadableState<T>()

    data class Error<T>(val errorMessage: String) : LoadableState<T>()
}
