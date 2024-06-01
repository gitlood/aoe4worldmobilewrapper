package com.example.aoe4worldmobilewrapper.di

import com.example.aoe4worldmobilewrapper.data.games.Games
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GamesApi {
    @GET("v0/games")
    suspend fun getGames(
        @Query("page") page: Int? = null,
        @Query("per_page") perPage: String? = "50",
        @Query("profile_ids") profileIds: String? = null,
        @Query("leaderboard") leaderboard: String? = null,
        @Query("since") since: String? = null, // Can be an integer or a datetime string
        @Query("updated_since") updatedSince: String? = null, // Can be an integer or a datetime string
        @Query("order") order: String? = "started_at"
    ): Response<Games>
}