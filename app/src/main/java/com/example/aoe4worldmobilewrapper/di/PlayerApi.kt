package com.example.aoe4worldmobilewrapper.di

import com.example.aoe4worldmobilewrapper.data.player.Player
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PlayerResource {
    @GET("{playerId}")
    suspend fun getMe(@Path("playerId") playerId: String): Response<Player> }
