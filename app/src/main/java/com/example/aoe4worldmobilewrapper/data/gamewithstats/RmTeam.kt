package com.example.aoe4worldmobilewrapper.data.gamewithstats

data class RmTeam(
    val games_count: Int,
    val losses_count: Int,
    val rank_level: String,
    val season: Int,
    val streak: Int,
    val wins_count: Int
)