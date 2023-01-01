@file:OptIn(ExperimentalMaterial3Api::class)

package com.majo.shikimori.animelist

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.majo.shikimori.animelist.model.Anime
import com.majo.shikimori.animelist.mvi.entity.AnimeListAction
import com.majo.shikimori.animelist.mvi.entity.AnimeListOneTimeEvent
import com.majo.shikimori.animelist.mvi.entity.AnimeListState
import kotlinx.coroutines.flow.Flow

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimeListScreen(viewModel: AnimeListViewModel, state: AnimeListState, events: Flow<AnimeListOneTimeEvent>) {
    val context = LocalContext.current
    LaunchedEffect(events) {
        events.collect { event ->
            when(event) {
                is AnimeListOneTimeEvent.ShowError -> {
                    Toast.makeText(context, event.error, Toast.LENGTH_SHORT).show()
                }
                else -> Unit
            }
        }
    }

    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Shikimori",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.White)
                )
            }) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
                    modifier = Modifier.padding(it)
                ) {
                    items(state.animeList) {
                        AnimeItem(viewModel, it)
                    }
                }
            }

    }
}

@Composable
fun AnimeItem(viewModel: AnimeListViewModel, anime: Anime) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .height(310.dp),
        onClick = {
            viewModel.accept(AnimeListAction.OpenAnimeDetailsScreen(anime.id))
        }
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
                text = anime.russianName.toString(),
                maxLines = 3,
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