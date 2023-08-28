package com.majo.shikimori.auth.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RefreshTokenRequestBody(
    @SerialName("grant_type") val grantType: String = "refresh_token",
    @SerialName("client_id") val clientId: String,
    @SerialName("client_secret") val clientSecret: String,
    @SerialName("refresh_token") val refreshToken: String,
)