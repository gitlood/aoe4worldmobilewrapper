package com.example.aoe4worldmobilewrapper.data.searchplayers

data class SearchPlayers(
    val count: Int,
    val filters: Filters,
    val offset: Int,
    val page: Int,
    val per_page: Int,
    val players: List<Player>,
    val total_count: Int
)