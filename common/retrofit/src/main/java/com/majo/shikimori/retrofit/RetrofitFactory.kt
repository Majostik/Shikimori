package com.majo.shikimori.retrofit

import com.majo.shikimori.anvil.AppScope
import com.squareup.anvil.annotations.ContributesBinding
import retrofit2.Retrofit
import javax.inject.Inject

interface RetrofitFactory {

    fun <T> create(service: Class<T>): T
}

