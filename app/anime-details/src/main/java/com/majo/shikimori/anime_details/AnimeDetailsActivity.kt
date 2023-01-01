package com.majo.shikimori.anime_details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.lifecycleScope
import com.majo.shikimori.android.lazySavedStateViewModel
import com.majo.shikimori.anime_details.di.DaggerAnimeDetailsComponent
import com.majo.shikimori.anime_details.mvi.entity.AnimeDetailsOneTimeEvent
import com.majo.shikimori.dagger.findComponentDependencies
import javax.inject.Inject

class AnimeDetailsActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: AnimeDetailsViewModel.Factory

    private val viewModel by lazySavedStateViewModel { viewModelFactory.create() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerAnimeDetailsComponent
            .factory()
            .create(
                dependencies = findComponentDependencies(),
                id = intent.getLongExtra(EXTRA_ID, 0L)
            )
            .inject(this)

        setContent {
            val composeState by viewModel.state.collectAsState()
            AnimeDetailsScreen(viewModel = viewModel, state = composeState, events = viewModel.events)
        }

        lifecycleScope.launchWhenCreated {
            viewModel.collectEvents(::handleEvents)
        }
    }

    private fun handleEvents(event: AnimeDetailsOneTimeEvent) {
        when(event) {
            is AnimeDetailsOneTimeEvent.Close -> finish()
            else -> Unit
        }
    }

    companion object {

        private const val EXTRA_ID = "com.majo.shikimori.id"

        fun createIntent(context: Context, id: Long) = Intent(context, AnimeDetailsActivity::class.java)
            .apply {
                putExtra(EXTRA_ID, id)
            }
    }
}