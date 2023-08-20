package com.majo.shikimori.animelist.model

import com.google.gson.annotations.SerializedName

data class Anime(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String?,
    @SerializedName("russian") val russianName: String?,
    @SerializedName("image") val image: Image?,
    @SerializedName("kind") val kind: String?,
    @SerializedName("score") val score: Double?,
    @SerializedName("status") val status: String?,
    @SerializedName("episodes") val episodes: Int?
)

data class Image(
    @SerializedName("original") val original: String?,
    @SerializedName("preview") val preview: String?,
    @SerializedName("x96") val x96: String?,
    @SerializedName("x48") val x48: String?
)