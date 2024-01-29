package com.majo.shikimori.anime_details

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AnimeDetailsArgs(
    val id: Long,
    val name: String,
) : Parcelable
