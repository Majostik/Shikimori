package com.majo.shikimori.retrofit

import com.majo.shikimori.dagger.anvil.AppScope
import com.squareup.anvil.annotations.ContributesBinding
import retrofit2.Retrofit
import javax.inject.Inject

interface RetrofitFactory {

    fun <T> create(service: Class<T>): T
}

@ContributesBinding(AppScope::class)
class RetrofitFactoryImpl @Inject constructor(private val retrofit: Retrofit): RetrofitFactory {

    override fun <T> create(service: Class<T>): T = retrofit.create(service)

}