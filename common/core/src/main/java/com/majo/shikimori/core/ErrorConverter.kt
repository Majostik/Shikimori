package com.majo.shikimori.core

import android.content.res.Resources
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

interface ErrorConverter {

    fun convertError(throwable: Throwable?): String
}

class ErrorConverterImpl @Inject constructor(
    private val resources: Resources
): ErrorConverter {
    override fun convertError(throwable: Throwable?): String {
        return if (throwable is UnknownHostException || throwable is SocketTimeoutException) {
            resources.getString(R.string.out_of_internet_error)
        } else {
            resources.getString(R.string.unknown_error)
        }
    }

}