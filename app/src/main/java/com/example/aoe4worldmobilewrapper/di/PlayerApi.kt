package com.example.aoe4worldmobilewrapper.di

import com.example.aoe4worldmobilewrapper.data.player.Player
import retrofit2.Response
import retrofit2.http.GET

interface PlayerResource {
    @GET("9705268")
    suspend fun getMe(): Response<Player>
}
