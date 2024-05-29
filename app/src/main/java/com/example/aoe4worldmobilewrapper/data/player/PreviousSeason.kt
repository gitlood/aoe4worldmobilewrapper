package com.example.aoe4worldmobilewrapper.data.player

data class PreviousSeason(
    val disputes_count: Int,
    val drops_count: Int,
    val games_count: Int,
    val last_game_at: String,
    val losses_count: Int,
    val rank: Int,
    val rank_level: String,
    val rating: Int,
    val season: Int,
    val streak: Int,
    val win_rate: Double,
    val wins_count: Int
)