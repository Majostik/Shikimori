package com.majo.shikimori

import android.app.Application
import com.majo.shikimori.di.component.DaggerAppComponent
import com.majo.shikimori.dagger.ComponentDependenciesProvider
import com.majo.shikimori.dagger.HasComponentDependencies
import javax.inject.Inject

class App: Application(), HasComponentDependencies {

    @Inject
    override lateinit var dependencies: ComponentDependenciesProvider
        protected set

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent
            .factory().create(this)
            .inject(this)
    }
}