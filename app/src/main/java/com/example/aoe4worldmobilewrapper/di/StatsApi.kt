package com.example.aoe4worldmobilewrapper.di

import com.example.aoe4worldmobilewrapper.data.stats.civilizations.Civilization
import com.example.aoe4worldmobilewrapper.data.stats.maps.Maps
import com.example.aoe4worldmobilewrapper.data.stats.matchups.Matchups
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface StatsApi {
    @GET("v0/stats/{game_type}/civilizations")
    suspend fun getStatsCivilizations(
        @Path("game_type") gameType: String,
        @Query("patch") patch: String? = null,
        @Query("rank_level") rankLevel: Int? = null,
        @Query("rating") rating: String? = null
    ): Response<Civilization>

    @GET("v0/stats/{game_type}/matchups")
    suspend fun getStatsMatchups(
        @Path("game_type") gameType: String,
        @Query("patch") patch: String? = null,
        @Query("rank_level") rankLevel: Int? = null,
        @Query("rating") rating: String? = null
    ): Response<Matchups>

    @GET("v0/stats/{game_type}/maps")
    suspend fun getStatsMaps(
        @Path("game_type") gameType: String,
        @Query("patch") patch: String? = null,
        @Query("rank_level") rankLevel: Int? = null,
        @Query("rating") rating: String? = null
    ): Response<Maps>
}