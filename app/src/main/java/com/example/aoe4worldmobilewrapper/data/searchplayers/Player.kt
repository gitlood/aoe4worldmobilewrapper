package com.example.aoe4worldmobilewrapper.data.searchplayers

import com.example.aoe4worldmobilewrapper.data.shared.Avatars
import com.example.aoe4worldmobilewrapper.data.shared.Social

data class Player(
    val avatars: Avatars,
    val country: String,
    val last_game_at: String,
    val name: String,
    val profile_id: Int,
    val social: Social,
    val steam_id: String
)