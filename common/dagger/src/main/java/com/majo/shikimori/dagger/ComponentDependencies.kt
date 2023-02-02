package com.majo.shikimori.dagger

import android.app.Activity
import android.content.Context
import androidx.fragment.app.Fragment
interface ComponentDependencies

inline fun <reified T : ComponentDependencies> Fragment.findComponentDependencies(): T {
    return getDependencies(findComponentDependenciesProvider())
}

inline fun <reified T : ComponentDependencies> Activity.findComponentDependencies(): T {
    return getDependencies(findComponentDependenciesProvider())
}

interface HasComponentDependencies {
    fun  getDependency(): AppComponentDependencies
}

interface AppComponentDependencies

@Suppress("UNCHECKED_CAST")
fun <T: ComponentDependencies> getDependencies(dependencyHolder: HasComponentDependencies): T {
    val dependencies = dependencyHolder.getDependency() as? T
    return dependencies ?: throw IllegalStateException("Missing Dependency")
}

fun Fragment.findComponentDependenciesProvider(): HasComponentDependencies {
    var current: Fragment? = parentFragment
    while (current !is HasComponentDependencies?) {
        current = current?.parentFragment
    }
    if (current != null) {
        return current
    }
    return activity?.findComponentDependenciesProvider() ?: throw IllegalStateException("No suitable provider")
}

fun Activity.findComponentDependenciesProvider(): HasComponentDependencies {
    return findComponentDependenciesProvider(this.application)
}

inline fun <reified T: Any> T.findComponentDependenciesProvider(context: Context): HasComponentDependencies {
    return when {
        this is HasComponentDependencies -> this
        context is HasComponentDependencies -> context
        else -> throw IllegalStateException("Can not find suitable dagger provider for $this")
    }
}