package com.majo.shikimori.di.component

import com.majo.shikimori.App
import com.majo.shikimori.dagger.AppComponentDependencies
import com.majo.shikimori.dagger.anvil.AppScope
import com.squareup.anvil.annotations.MergeComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@MergeComponent(scope = AppScope::class,)
interface AppComponent: AppComponentDependencies {

    fun inject(app: App)

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance app: App): AppComponent
    }
}