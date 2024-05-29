package com.example.aoe4worldmobilewrapper.data.player

data class Player(
    val avatars: Avatars,
    val country: String,
    val modes: Modes,
    val name: String,
    val profile_id: Int,
    val site_url: String,
    val social: Social,
    val steam_id: String
)