package com.example.aoe4worldmobilewrapper.data.games

data class Game(
    val average_mmr: Any,
    val average_mmr_deviation: Any,
    val average_rating: Any,
    val average_rating_deviation: Any,
    val duration: Any,
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