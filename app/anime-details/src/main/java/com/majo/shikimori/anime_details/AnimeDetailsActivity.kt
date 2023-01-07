package com.majo.shikimori.anime_details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.lifecycleScope
import com.majo.shikimori.android.getArgs
import com.majo.shikimori.android.lazySavedStateViewModel
import com.majo.shikimori.android.putArgs
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
        val args = intent?.getArgs<AnimeDetailsArgs>()

        DaggerAnimeDetailsComponent
            .factory()
            .create(
                dependencies = findComponentDependencies(),
                id = args?.id ?: 0L
            )
            .inject(this)

        setContent {
            val composeState by viewModel.state.collectAsState()
            AnimeDetailsScreen(
                viewModel = viewModel,
                state = composeState,
                events = viewModel.events,
                args = args
            )
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

        fun createIntent(context: Context, args: AnimeDetailsArgs) =
            Intent(context, AnimeDetailsActivity::class.java)
                .putArgs(args)
    }
}