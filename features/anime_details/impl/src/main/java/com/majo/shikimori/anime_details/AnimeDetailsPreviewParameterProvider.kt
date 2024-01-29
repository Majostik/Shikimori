package com.majo.shikimori.anime_details

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.majo.anime_details.model.AnimeDetails

class AnimeDetailsPreviewParameterProvider : PreviewParameterProvider<AnimeDetails> {
    override val values: Sequence<AnimeDetails>
        get() = sequenceOf(
            AnimeDetails(
                id = 1,
                name = "test",
                russianName = null,
                description = "description",
                image = null,
                kind = "test",
                score = 1.5,
                status = "test",
                episodes = 1,
                genres = mutableListOf(),
            ),
        )
}
