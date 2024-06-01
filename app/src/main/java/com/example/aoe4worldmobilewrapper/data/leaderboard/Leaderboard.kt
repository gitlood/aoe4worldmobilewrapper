package com.example.aoe4worldmobilewrapper.data.leaderboard

data class Leaderboard(
    val count: Int,
    val key: String,
    val name: String,
    val offset: Int,
    val page: Int,
    val per_page: Int,
    val players: List<Player>,
    val query: Any,
    val short_name: String,
    val site_url: String,
    val total_count: Int
)