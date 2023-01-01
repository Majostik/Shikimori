package com.majo.shikimori.android

import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner

class SaveStateViewModelFactory<out VM : ViewModel>(
    savedStateRegistryOwner: SavedStateRegistryOwner,
    private val create: (stateHandle: SavedStateHandle) -> VM
) : AbstractSavedStateViewModelFactory(savedStateRegistryOwner, null) {

    override fun <VM : ViewModel> create(key: String, modelClass: Class<VM>, handle: SavedStateHandle): VM =
        create.invoke(handle) as VM
}


inline fun <reified T : ViewModel> ComponentActivity.lazySavedStateViewModel(
    noinline create: (stateHandle: SavedStateHandle) -> T
): Lazy<T> = viewModels { SaveStateViewModelFactory(this, create) }

inline fun <reified T : ViewModel> Fragment.lazySavedStateViewModel(
    noinline create: (stateHandle: SavedStateHandle) -> T
): Lazy<T> = viewModels { SaveStateViewModelFactory(this, create) }