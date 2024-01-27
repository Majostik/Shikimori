package com.majo.shikimori

import android.app.Application
import com.majo.shikimori.dagger.ComponentDependenciesProvider
import com.majo.shikimori.dagger.HasComponentDependencies
import com.majo.shikimori.di.DependenciesManager
import com.majo.shikimori.di.component.AppEntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App: Application(), HasComponentDependencies {

    override val dependencies: ComponentDependenciesProvider
        get() = DependenciesManager.getDependencies(EntryPoints.get(this, AppEntryPoint::class.java))

}