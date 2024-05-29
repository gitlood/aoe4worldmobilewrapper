package com.example.aoe4worldmobilewrapper.data.gamewithstats

data class Team(
    val avatars: Avatars,
    val civilization: String,
    val country: String,
    val input_type: String,
    val mmr: Int,
    val mmr_diff: Int,
    val modes: Modes,
    val name: String,
    val profile_id: Int,
    val rating: Int,
    val rating_diff: Int,
    val result: String,
    val site_url: String,
    val social: Social,
    val steam_id: String
)