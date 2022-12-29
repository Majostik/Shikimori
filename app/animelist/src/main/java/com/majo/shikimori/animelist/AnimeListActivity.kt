package com.majo.shikimori.animelist

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.majo.shikimori.animelist.di.DaggerAnimeListComponent
import com.majo.shikimori.animelist.model.Anime
import com.majo.shikimori.dagger.findComponentDependencies
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AnimeListActivity: AppCompatActivity() {

    @Inject
    lateinit var animeListApi: AnimeListApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerAnimeListComponent
            .factory()
            .create(findComponentDependencies())
            .inject(this)
        GlobalScope.launch {
            val list = animeListApi.getAnimes()
            withContext(Dispatchers.Main) {
                setContent {
                    AnimeList(list)
                }
            }
        }
    }

    @Composable
    fun AnimeList(animes: List<Anime>) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp)
        ) {
            items(animes) {
                AnimeItem(it)
            }
        }
    }

    @Composable
    fun AnimeItem(anime: Anime) {
        Column {
            Box {
                AsyncImage(
                    model = "https://shikimori.one/" + anime.image?.original,
                    contentDescription = anime.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(250.dp)
                        .fillMaxWidth()
                )
                Box(modifier = Modifier
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
                color = Color.Black,
                fontSize = 20.sp
            )
            Text(
                text = anime.kind.toString(),
                color = Color.Gray,
                fontSize = 18.sp
            )
        }
    }
}