package com.example.aoe4worldmobilewrapper.data.player

data class Rm1v1(
    val _notice_: String,
    val civilizations: List<Civilization>,
    val disputes_count: Int,
    val drops_count: Int,
    val games_count: Int,
    val last_game_at: String,
    val losses_count: Int,
    val max_rating: Int,
    val max_rating_1m: Int,
    val max_rating_7d: Int,
    val previous_seasons: List<PreviousSeason>,
    val rank: Int,
    val rank_level: String,
    val rating: Int,
    val season: Int,
    val streak: Int,
    val win_rate: Double,
    val wins_count: Int
)