package com.example.aoe4worldmobilewrapper.data.playersgames

data class Player(
    val civilization: String,
    val civilization_randomized: Boolean,
    val input_type: String,
    val mmr: Int,
    val mmr_diff: Int,
    val name: String,
    val profile_id: Int,
    val rating: Int,
    val rating_diff: Int,
    val result: String
)