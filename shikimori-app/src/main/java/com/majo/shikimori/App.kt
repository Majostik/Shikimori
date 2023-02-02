package com.majo.shikimori

import android.app.Application
import com.majo.shikimori.dagger.AppComponentDependencies
import com.majo.shikimori.dagger.ComponentDependencies
import com.majo.shikimori.di.component.DaggerAppComponent
import com.majo.shikimori.dagger.HasComponentDependencies
import com.majo.shikimori.di.component.AppComponent

class App: Application(), HasComponentDependencies {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .factory()
            .create(this)
        appComponent.inject(this)
    }

    override fun getDependency(): AppComponentDependencies {
        return appComponent
    }


}