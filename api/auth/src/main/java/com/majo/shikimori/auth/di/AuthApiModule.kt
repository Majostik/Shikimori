package com.majo.shikimori.auth.di

import com.majo.shikimori.anvil.AppScope
import com.majo.shikimori.auth.AuthApi
import com.majo.shikimori.retrofit.RetrofitFactory
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides
import dagger.Reusable
import javax.inject.Named

@Module
@ContributesTo(AppScope::class)
object AuthApiModule {

    @Provides
    @Reusable
    fun provideAuthApi(@Named("auth") retrofitFactory: RetrofitFactory): AuthApi {
        return retrofitFactory.create(AuthApi::class.java)
    }
}