package com.majo.shikimori.di.component

import com.majo.shikimori.App
import com.majo.shikimori.animelist.di.AnimeListDependencies
import com.majo.shikimori.di.module.ApiModule
import com.majo.shikimori.di.module.AppModule
import com.majo.shikimori.di.module.DependenciesModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiModule::class,
        AppModule::class,
        DependenciesModule::class
    ]
)
interface AppComponent:
    AnimeListDependencies
{

    fun inject(app: App)

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance app: App): AppComponent
    }
}