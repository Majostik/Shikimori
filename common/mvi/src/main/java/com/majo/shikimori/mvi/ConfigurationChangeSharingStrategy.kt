package com.majo.shikimori.mvi

import kotlinx.coroutines.flow.SharingStarted

const val CONFIG_CHANGE_TIMEOUT = 5000L
val ConfigurationChangeSharingStrategy = SharingStarted.WhileSubscribed(CONFIG_CHANGE_TIMEOUT)
