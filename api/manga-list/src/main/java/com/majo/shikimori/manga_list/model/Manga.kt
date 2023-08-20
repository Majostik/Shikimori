package com.majo.shikimori.manga_list.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Manga(
    @SerialName("id") val id: Long,
    @SerialName("name") val name: String?,
    @SerialName("russian") val russianName: String?,
    @SerialName("image") val image: Image?,
    @SerialName("kind") val kind: String?,
    @SerialName("score") val score: String?,
    @SerialName("status") val status: String?,
    @SerialName("volumes") val volumes: Int?,
    @SerialName("chapters") val chapters: Int?
)

@Serializable
data class Image(
    @SerialName("original") val original: String?,
    @SerialName("preview") val preview: String?,
    @SerialName("x96") val x96: String?,
    @SerialName("x48") val x48: String?
)