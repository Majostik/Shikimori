package com.majo.shikimori.anime_details

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.majo.anime_details.model.AnimeDetails
import com.majo.shikimori.android.LoadableState
import com.majo.shikimori.animeDetailsImpl.R
import com.majo.shikimori.anime_details.di.DaggerAnimeDetailsComponent
import com.majo.shikimori.anime_details.mvi.entity.AnimeDetailsAction
import com.majo.shikimori.anime_details.mvi.entity.AnimeDetailsOneTimeEvent
import com.majo.shikimori.anime_details.mvi.entity.AnimeDetailsState
import com.majo.shikimori.compose.ShikimoriTheme
import com.majo.shikimori.compose.components.ErrorState
import com.majo.shikimori.compose.components.LoadingState
import com.majo.shikimori.dagger.daggerViewModel
import com.majo.shikimori.dagger.findComponentDependencies
import kotlinx.coroutines.flow.Flow


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimeDetailsScreen(
    navController: NavHostController,
    args: AnimeDetailsArgs
) {
    val context = LocalContext.current

    val component = DaggerAnimeDetailsComponent.factory().create(
        dependencies = context.findComponentDependencies(),
        id = args.id
    )
    val viewModel = daggerViewModel {
        component.viewModel()
    }
    val state by viewModel.state.collectAsState()
    val events = viewModel.events

    LaunchedEffect(events) {
        events.collect { event ->
            when(event) {
                is AnimeDetailsOneTimeEvent.ShowError -> {
                    Toast.makeText(context, event.error, Toast.LENGTH_SHORT).show()
                }
                is AnimeDetailsOneTimeEvent.Close -> {
                    navController.popBackStack()
                }
            }
        }
    }

    ShikimoriTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {},
                    navigationIcon = {
                        IconButton(onClick = {
                            viewModel.accept(AnimeDetailsAction.Back)
                        }){
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "back"
                            )
                        }
                    }
                )
            }) { paddingValues ->
                when (val data = state.data) {
                    is LoadableState.Loading -> {
                        LoadingState(paddingValues)
                    }
                    is LoadableState.Loaded -> {
                        AnimeDetailsContent(data.data, paddingValues)
                    }
                    is LoadableState.Error -> {
                        ErrorState(data.errorMessage, paddingValues) {
                            viewModel.accept(AnimeDetailsAction.LoadData)
                        }
                    }
                }

        }
    }
}

@Composable
fun AnimeDetailsContent(anime: AnimeDetails, paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(paddingValues)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            AsyncImage(
                model = "https://shikimori.one/" + anime.image?.original,
                contentDescription = anime.name,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .height(300.dp)
                    .width(200.dp)
            )
            Column {
                if (anime.kind != null) {
                    Text(
                        text = stringResource(id = R.string.anime_details_type),
                        color = Color.Gray,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                    Text(
                        text = anime.kind.toString(),
                        color = Color.Black,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                }
                if (anime.episodes != null && anime.episodes != 0) {
                    Text(
                        text = stringResource(id = R.string.anime_details_episodes),
                        color = Color.Gray,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                    Text(
                        text = anime.episodes.toString(),
                        color = Color.Black,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                }
                if (anime.status != null) {
                    Text(
                        text = stringResource(id = R.string.anime_details_status),
                        color = Color.Gray,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                    Text(
                        text = anime.status.toString(),
                        color = Color.Black,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                }
                if (anime.score != null && anime.score != 0.0) {
                    Text(
                        text = stringResource(id = R.string.anime_details_rating),
                        color = Color.Gray,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                    Text(
                        text = anime.score.toString(),
                        color = Color.Black,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                }
            }
        }
        if (anime.name != null || anime.russianName != null)
            Text(
                text = if (anime.name != null && anime.russianName != null)
                    stringResource(id = R.string.anime_details_name, anime.name.toString(), anime.russianName.toString())
                else if (anime.name != null) {
                    anime.name.toString()
                } else {
                    anime.russianName.toString()
                },
                color = Color.Black,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp),
            )
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        ) {
            items(anime.genres.orEmpty()) {
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
        if (anime.description != null) {
            var expanded by remember {
                mutableStateOf(false)
            }
            Box(
                modifier = if (expanded) Modifier
                    .wrapContentHeight()
                    .padding(horizontal = 16.dp)
                else
                    Modifier
                        .height(150.dp)
                        .padding(horizontal = 16.dp),
                contentAlignment = Alignment.BottomCenter,
            ) {
                Column {
                    Text(
                        text = stringResource(id = R.string.anime_details_description),
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Gray,
                        modifier = Modifier
                            .padding(vertical = 8.dp),
                    )
                    Text(
                        text = anime.description.toString(),
                        style = MaterialTheme.typography.bodyLarge,
                    )
                }
                if (!expanded) {
                        Text(
                            text = stringResource(id = R.string.anime_details_show_description),
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier
                                .background(Color.White)
                                .fillMaxWidth()
                                .padding(vertical = 8.dp)
                                .clickable {
                                    expanded = true
                                }
                        )

                }
            }
        }
    }
}

@Composable
@Preview
fun AnimeDetailsContentPreview(
    @PreviewParameter(AnimeDetailsPreviewParameterProvider::class) data: AnimeDetails
) {
    AnimeDetailsContent(anime = data, paddingValues = PaddingValues())
}
