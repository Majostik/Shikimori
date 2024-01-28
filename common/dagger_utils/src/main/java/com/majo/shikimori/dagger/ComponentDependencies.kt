package com.majo.shikimori.dagger

import android.app.Activity
import android.content.Context
import androidx.fragment.app.Fragment
import dagger.MapKey
import kotlin.reflect.KClass

interface ComponentDependencies

inline fun <reified T : ComponentDependencies> Context.findComponentDependencies(): T {
    return getDependencies(T::class.java, findComponentDependenciesProvider(this))
}

typealias ComponentDependenciesProvider = Map<Class<out ComponentDependencies>, @JvmSuppressWildcards ComponentDependencies>

interface HasComponentDependencies {
    val dependencies: ComponentDependenciesProvider
}

@MapKey
@Target(AnnotationTarget.FUNCTION)
annotation class ComponentDependenciesKey(val value: KClass<out ComponentDependencies>)

@Suppress("UNCHECKED_CAST")
fun <T: ComponentDependencies> getDependencies(clazz: Class<T>, dependencyHolder: HasComponentDependencies): T {
    val dependencies = dependencyHolder.dependencies.get(clazz) as? T
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
    val appContext = context.applicationContext
    return when {
        this is HasComponentDependencies -> this
        appContext is HasComponentDependencies -> appContext
        else -> throw IllegalStateException("Can not find suitable dagger provider for $this")
    }
}