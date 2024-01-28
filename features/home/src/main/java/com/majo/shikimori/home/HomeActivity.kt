package com.majo.shikimori.home

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.majo.shikimori.dagger.ComponentDependenciesProvider
import com.majo.shikimori.dagger.HasComponentDependencies

class HomeActivity : AppCompatActivity(), HasComponentDependencies {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }

    override val dependencies: ComponentDependenciesProvider
        get() = (application as HasComponentDependencies).dependencies
}