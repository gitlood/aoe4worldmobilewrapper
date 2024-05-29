package com.example.aoe4worldmobilewrapper.domain

import com.example.aoe4worldmobilewrapper.di.PlayerResource
import javax.inject.Inject

class PlayerUseCase @Inject constructor(val playerResource: PlayerResource) {

    suspend fun getMe(){
        print(playerResource.getMe("9705268").body()?.name)
    }
}