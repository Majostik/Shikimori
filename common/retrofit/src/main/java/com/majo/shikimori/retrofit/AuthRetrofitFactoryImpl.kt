package com.majo.shikimori.retrofit

import com.majo.shikimori.anvil.AppScope
import com.squareup.anvil.annotations.ContributesBinding
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Named

@ContributesBinding(AppScope::class)
@Named("auth")
class AuthRetrofitFactoryImpl @Inject constructor(@Named("auth") private val retrofit: Retrofit): RetrofitFactory {

    override fun <T> create(service: Class<T>): T = retrofit.create(service)

}