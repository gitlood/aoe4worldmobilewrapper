package com.example.aoe4worldmobilewrapper.data.games

data class Player(
    val civilization: String,
    val civilization_randomized: Boolean,
    val input_type: String,
    val mmr: Any,
    val mmr_diff: Any,
    val name: String,
    val profile_id: Int,
    val rating: Any,
    val rating_diff: Any,
    val result: Any
)