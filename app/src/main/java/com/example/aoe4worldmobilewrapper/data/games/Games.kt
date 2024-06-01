package com.example.aoe4worldmobilewrapper.data.games

data class Games(
    val count: Int,
    val filters: Filters,
    val games: List<Game>,
    val offset: Int,
    val page: Int,
    val per_page: Int
)