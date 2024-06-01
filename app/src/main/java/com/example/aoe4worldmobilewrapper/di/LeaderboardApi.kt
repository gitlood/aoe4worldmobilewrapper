package com.example.aoe4worldmobilewrapper.di

import com.example.aoe4worldmobilewrapper.data.leaderboard.Leaderboard
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface LeaderboardApi {
    @GET("v0/leaderboards/{leaderboard}")
    suspend fun getLeaderboard(
        @Path("leaderboard") leaderboard: String,
        @Query("page") page: Int? = null,
        @Query("query") query: String? = null,
        @Query("profile_id") profileId: Int? = null
    ): Response<Leaderboard>
}