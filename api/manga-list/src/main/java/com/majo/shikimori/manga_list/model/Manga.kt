package com.majo.shikimori.manga_list.model

import com.google.gson.annotations.SerializedName

data class Manga(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String?,
    @SerializedName("russian") val russianName: String?,
    @SerializedName("image") val image: Image?,
    @SerializedName("kind") val kind: String?,
    @SerializedName("score") val score: String?,
    @SerializedName("status") val status: String?,
    @SerializedName("volumes") val volumes: Int?,
    @SerializedName("chapters") val chapters: Int?
)

data class Image(
    @SerializedName("original") val original: String?,
    @SerializedName("preview") val preview: String?,
    @SerializedName("x96") val x96: String?,
    @SerializedName("x48") val x48: String?
)