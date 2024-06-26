package com.example.aoe4worldmobilewrapper.data.player

data class GameLength(
    val average: Double,
    val breakdown: List<Breakdown>,
    val losses_average: Double,
    val losses_median: Double,
    val median: Double,
    val wins_average: Double,
    val wins_median: Double
)