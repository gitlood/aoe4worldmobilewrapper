package com.example.aoe4worldmobilewrapper.data.stats.maps

data class Data(
    val civilization: Any,
    val duration_average: Int,
    val duration_maximum: Int,
    val duration_median: Int,
    val duration_minimum: Int,
    val duration_percentile95: Int,
    val games_count: Int,
    val highest_win_rate_civilization: String,
    val loss_count: Int,
    val map: String,
    val map_id: Int,
    val player_games_count: Int,
    val win_count: Int,
    val win_rate: Double
)