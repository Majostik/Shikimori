package com.majo.shikimori.auth

import com.majo.shikimori.auth.model.AccessToken
import com.majo.shikimori.auth.request.AccessTokenRequestBody
import com.majo.shikimori.auth.request.RefreshTokenRequestBody
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {


    @POST("token")
    suspend fun getAccessToken(@Body accessTokenRequestBody: AccessTokenRequestBody): AccessToken

    @POST("token")
    suspend fun refreshAccessToken(@Body refreshTokenRequestBody: RefreshTokenRequestBody): AccessToken
}