package com.example.aoe4worldmobilewrapper.data.game

data class Game(
    val average_mmr: Int,
    val average_mmr_deviation: Any,
    val average_rating: Int,
    val average_rating_deviation: Any,
    val duration: Int,
    val filters: Filters,
    val game_id: Int,
    val just_finished: Boolean,
    val kind: String,
    val leaderboard: String,
    val map: String,
    val mmr_leaderboard: String,
    val ongoing: Boolean,
    val patch: Int,
    val season: Int,
    val server: String,
    val started_at: String,
    val teams: List<List<Team>>,
    val updated_at: String
)