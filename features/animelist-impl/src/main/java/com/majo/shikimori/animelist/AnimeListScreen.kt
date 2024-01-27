@file:OptIn(ExperimentalMaterial3Api::class)

package com.majo.shikimori.animelist

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.majo.shikimori.anime_list.impl.R
import com.majo.shikimori.animelist.di.DaggerAnimeListComponent
import com.majo.shikimori.animelist.model.Anime
import com.majo.shikimori.animelist.mvi.entity.AnimeListAction
import com.majo.shikimori.animelist.mvi.entity.AnimeListOneTimeEvent
import com.majo.shikimori.compose.ShikimoriTheme
import com.majo.shikimori.compose.components.TopAppBarWithSearch
import com.majo.shikimori.dagger.findComponentDependencies

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimeListScreen(navController: NavHostController) {
    val context = LocalContext.current
    val animeListComponent = DaggerAnimeListComponent.builder().dependencies(context.findComponentDependencies()).build()

    val viewModel = hiltViewModel<AnimeListViewModel>()
    val state by viewModel.state.collectAsState()
    val events = viewModel.events
    viewModel.accept(AnimeListAction.Init)

    val lazyGridListState = rememberLazyGridState()

    val shouldStartPaginate = remember {
        derivedStateOf {
            !state.isLoading && (lazyGridListState.layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: -9) >= (lazyGridListState.layoutInfo.totalItemsCount - 6)
        }
    }

    LaunchedEffect(shouldStartPaginate.value) {
        if (shouldStartPaginate.value && !state.isLoading)
            viewModel.accept(AnimeListAction.LoadNextPage(page = state.page + 1))
    }

    LaunchedEffect(events) {
        events.collect { event ->
            when(event) {
                is AnimeListOneTimeEvent.ShowError -> {
                    Toast.makeText(context, event.error, Toast.LENGTH_SHORT).show()
                }
                is AnimeListOneTimeEvent.OpenScreen -> {
                    navController.navigate(animeListComponent.animeDetailsScreenProvider().animeDetailsScreen(event.name, event.id))
                }
            }
        }
    }

    ShikimoriTheme {
        Scaffold(
            topBar = {
                TopAppBarWithSearch(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    title = {
                        Text(
                            text = stringResource(R.string.anime_list_title),
                            color = Color.Black,
                            style = MaterialTheme.typography.titleMedium
                        )
                    },
                    onSearchResult = {
                        viewModel.accept(AnimeListAction.Search(query = it))
                    }
                )
            }) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
                    modifier = Modifier.padding(it),
                    state = lazyGridListState
                ) {
                    items(state.animeList) {anime ->
                        AnimeItem(anime) {
                            viewModel.accept(AnimeListAction.OpenAnimeDetailsScreen(anime.id, anime.name))
                        }
                    }
                }
            }

    }
}

@Composable
fun AnimeItem(anime: Anime, onItemClick:() -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .height(290.dp),
        onClick = onItemClick
    ) {
        Column {
            Box {
                AsyncImage(
                    model = "https://shikimori.one/" + anime.image?.original,
                    contentDescription = anime.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth()
                )
                if (anime.score != 0.0)
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.BottomStart)
                            .background(Color.Black.copy(alpha = 0.3f))
                    ) {
                        Text(
                            text = anime.score.toString(),
                            color = Color.White,
                            fontSize = 16.sp,
                            modifier = Modifier
                                .padding(4.dp),
                        )
                    }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = anime.name.toString(),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            Text(
                text = anime.kind.toString(),
                color = Color.Gray,
                fontSize = 14.sp,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}