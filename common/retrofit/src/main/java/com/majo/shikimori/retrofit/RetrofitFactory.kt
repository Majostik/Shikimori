package com.majo.shikimori.retrofit

import retrofit2.Retrofit
import javax.inject.Inject

interface RetrofitFactory {

    fun <T> create(service: Class<T>): T
}

class RetrofitFactoryImpl @Inject constructor(private val retrofit: Retrofit): RetrofitFactory {

    override fun <T> create(service: Class<T>): T = retrofit.create(service)

}