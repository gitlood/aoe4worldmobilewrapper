package com.example.aoe4worldmobilewrapper.data.playersgames

data class PlayersGames(
    val count: Int,
    val filters: Filters,
    val games: List<Game>,
    val offset: Int,
    val page: Int,
    val per_page: Int,
    val total_count: Int
)