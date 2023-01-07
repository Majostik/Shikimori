package com.majo.shikimori.android

import android.content.Intent
import android.os.Build
import android.os.Parcelable

const val EXTRA_ARGS = "args"

fun<T: Parcelable> Intent.putArgs(args: T): Intent {
    return putExtra(EXTRA_ARGS, args)
}

inline fun<reified T: Parcelable> Intent.getArgs(): T? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        getParcelableExtra(EXTRA_ARGS, T::class.java)
    } else {
        getParcelableExtra(EXTRA_ARGS)
    }
}
