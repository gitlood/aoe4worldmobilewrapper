package com.example.aoe4worldmobilewrapper.di

import com.example.aoe4worldmobilewrapper.data.game.Game
import com.example.aoe4worldmobilewrapper.data.gamewithstats.GameWithStats
import com.example.aoe4worldmobilewrapper.data.player.Player
import com.example.aoe4worldmobilewrapper.data.playersgames.PlayersGames
import com.example.aoe4worldmobilewrapper.data.searchplayers.SearchPlayers
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PlayerApi {
    @GET("v0/players/{playerId}")
    suspend fun getPlayer(@Path("playerId") playerId: String): Response<Player>

    @GET("v0/players/{profile_id}/games")
    suspend fun getPlayerGames(
        @Path("profile_id") profileId: String,
        @Query("page") page: Int? = null,
        @Query("limit") limit: Int? = null,
        @Query("leaderboard") leaderboard: String? = null,
        @Query("opponent_profile_id") opponentProfileId: Int? = null,
        @Query("since") since: String? = null, // Can be an integer or a datetime string
        @Query("include_alts") includeAlts: Boolean? = null,
    ): Response<PlayersGames>

    @GET("v0/players/{profile_id}/games/{game_id}")
    suspend fun getPlayerGame(
        @Path("profile_id") profileId: String,
        @Path("game_id") gameId: String,
        @Query("include_alts") includeAlts: Boolean? = null,
        @Query("api_key") apiKey: String? = null
    ): Response<Game>

    @GET("v0/players/{profile_id}/games/last")
    suspend fun getPlayerLastGameWithStats(
        @Path("profile_id") profileId: String,
        @Query("include_alts") includeAlts: Boolean? = null,
        @Query("include_stats") includeStats: Boolean? = null
    ): Response<GameWithStats>

    @GET("v0/players/search")
    suspend fun searchPlayers(
        @Query("query") query: String,
        @Query("page") page: Int? = null,
        @Query("exact") exact: Boolean? = null
    ): Response<SearchPlayers>
}
