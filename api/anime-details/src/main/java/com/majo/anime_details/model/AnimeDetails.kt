package com.majo.anime_details.model

import com.google.gson.annotations.SerializedName

data class AnimeDetails(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String?,
    @SerializedName("russian") val russianName: String?,
    @SerializedName("image") val image: Image?,
    @SerializedName("kind") val kind: String?,
    @SerializedName("score") val score: String?,
    @SerializedName("status") val status: String?,
    @SerializedName("episodes") val episodes: Int?,
    @SerializedName("description") val description: String?,
    @SerializedName("genres") val genres: List<Genre>?,
)

data class Image(
    @SerializedName("original") val original: String?,
    @SerializedName("preview") val preview: String?,
    @SerializedName("x96") val x96: String?,
    @SerializedName("x48") val x48: String?
)

data class Genre(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("russian") val russianName: String?,
    @SerializedName("kind") val kind: String?,
)