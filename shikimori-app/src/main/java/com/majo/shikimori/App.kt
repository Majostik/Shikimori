package com.majo.shikimori

import android.app.Application
import com.majo.shikimori.dagger.ComponentDependenciesProvider
import com.majo.shikimori.di.component.DaggerAppComponent
import com.majo.shikimori.dagger.HasComponentDependencies
import com.majo.shikimori.di.component.AppComponent
import javax.inject.Inject

class App: Application(), HasComponentDependencies {

    private lateinit var appComponent: AppComponent

    @Inject
    override lateinit var dependencies: ComponentDependenciesProvider
        protected set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .factory()
            .create(this)
        appComponent.inject(this)
    }

}