package com.example.aoe4worldmobilewrapper.data.player

data class Civilization(
    val civilization: String,
    val game_length: GameLength,
    val games_count: Int,
    val pick_rate: Double,
    val win_rate: Double
)