package com.majo.shikimori.anime_details

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.majo.shikimori.anime_details.di.DaggerAnimeDetailsComponent
import com.majo.shikimori.anime_details.mvi.entity.AnimeDetailsAction
import com.majo.shikimori.anime_details.mvi.entity.AnimeDetailsOneTimeEvent
import com.majo.shikimori.anime_details.mvi.entity.AnimeDetailsState
import com.majo.shikimori.compose.ShikimoriTheme
import com.majo.shikimori.dagger.findComponentDependencies
import kotlinx.coroutines.flow.Flow


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimeDetailsScreen(
    args: AnimeDetailsArgs
) {
    val context = LocalContext.current

    val component = DaggerAnimeDetailsComponent.factory().create(
        dependencies = context.findComponentDependencies(),
        id = args.id
    )
    val viewModel = component.viewModel()
    val state by viewModel.state.collectAsState()
    val events = viewModel.events

    LaunchedEffect(events) {
        events.collect { event ->
            when(event) {
                is AnimeDetailsOneTimeEvent.ShowError -> {
                    Toast.makeText(context, event.error, Toast.LENGTH_SHORT).show()
                }
                else -> Unit
            }
        }
    }

    ShikimoriTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = args.name,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.clickable {
                                viewModel.accept(AnimeDetailsAction.LoadData)
                            }
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            viewModel.accept(AnimeDetailsAction.Back)
                        }){
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "back"
                            )
                        }
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.White)
                )
            }) {
                AnimeDetailsContent(state, it)
        }
    }
}

@Composable
fun AnimeDetailsContent(state: AnimeDetailsState, paddingValues: PaddingValues) {
    val anime = state.animeDetails
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
        ) {
            AsyncImage(
                model = "https://shikimori.one/" + anime?.image?.original,
                contentDescription = anime?.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(300.dp)
                    .width(200.dp)
            )
            Column {
                Text(
                    text = anime?.russianName.toString(),
                    overflow = TextOverflow.Ellipsis,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
                Text(
                    text = anime?.kind.toString(),
                    color = Color.Black,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
                Text(
                    text = anime?.episodes.toString(),
                    color = Color.Black,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
                Text(
                    text = anime?.status.toString(),
                    color = Color.Black,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
                Text(
                    text = anime?.score.toString(),
                    color = Color.Black,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        }
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
        ) {
            items(anime?.genres.orEmpty()) {
                Box(
                    modifier = Modifier
                        .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(8.dp))
                ) {
                    Text(
                        text = it.russianName.toString(),
                        color = Color.Black,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .padding(4.dp),
                    )
                }
            }
        }
        Text(
            text = anime?.description.toString(),
            color = Color.Black,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(8.dp),
        )
    }
}