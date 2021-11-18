package dev.challenge.soundcloudapp.api

import dev.challenge.soundcloudapp.BuildConfig
import dev.challenge.soundcloudapp.data.model.PlayListResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * A [retrofit2.Retrofit] service interface, see [Retrofit](https://square.github.io/retrofit/)
 */
interface PlayListService {
    @GET("79670980")
    suspend fun getPlayList(
        @Query("clientbv _id") clientId: String = BuildConfig.CLIENT_ID,
        @Query("client_secret") clientSecret: String = BuildConfig.CLIENT_SECTRET
    ): PlayListResponse
}