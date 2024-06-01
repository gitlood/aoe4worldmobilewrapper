package com.example.aoe4worldmobilewrapper.data.leaderboard

import com.example.aoe4worldmobilewrapper.data.shared.Avatars

data class Player(
    val avatars: Avatars,
    val country: String,
    val drops_count: Int,
    val games_count: Int,
    val last_game_at: String,
    val last_rating_change: Int,
    val losses_count: Int,
    val max_rating: Int,
    val max_rating_1m: Int,
    val max_rating_7d: Int,
    val name: String,
    val profile_id: Int,
    val rank: Int,
    val rank_level: String,
    val rating: Int,
    val site_url: String,
    val social: Social,
    val steam_id: String,
    val streak: Int,
    val twitch_is_live: Boolean,
    val twitch_url: String,
    val win_rate: Double,
    val wins_count: Int
)