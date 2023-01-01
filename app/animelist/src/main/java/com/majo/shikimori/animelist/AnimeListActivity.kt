package com.majo.shikimori.animelist

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.lifecycleScope
import com.majo.shikimori.android.lazySavedStateViewModel
import com.majo.shikimori.animelist.di.DaggerAnimeListComponent
import com.majo.shikimori.animelist.mvi.entity.AnimeListOneTimeEvent
import com.majo.shikimori.dagger.findComponentDependencies
import javax.inject.Inject

class AnimeListActivity: AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: AnimeListViewModel.Factory

    private val viewModel by lazySavedStateViewModel { viewModelFactory.create() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerAnimeListComponent
            .factory()
            .create(findComponentDependencies())
            .inject(this)

        setContent {
            val composeState by viewModel.state.collectAsState()
            AnimeListScreen(viewModel = viewModel, state = composeState, events = viewModel.events)
        }

        lifecycleScope.launchWhenCreated {
            viewModel.collectEvents(::handleEvents)
        }
    }

    private fun handleEvents(event: AnimeListOneTimeEvent) {
        when(event) {
            is AnimeListOneTimeEvent.OpenScreen -> {
                startActivity(event.intent)
            }
            else -> Unit
        }
    }

    companion object {

        fun createIntent(context: Context) = Intent(context, AnimeListActivity::class.java)
    }

}