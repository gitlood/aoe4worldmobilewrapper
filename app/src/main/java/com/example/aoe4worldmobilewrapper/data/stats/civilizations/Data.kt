package com.example.aoe4worldmobilewrapper.data.stats.civilizations

data class Data(
    val civilization: String,
    val duration_average: Int,
    val duration_maximum: Int,
    val duration_median: Int,
    val duration_minimum: Int,
    val duration_percentile95: Int,
    val games_count: Int,
    val loss_count: Int,
    val pick_rate: Double,
    val player_games_count: Int,
    val win_count: Int,
    val win_rate: Double
)