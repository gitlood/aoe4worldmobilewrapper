package com.example.aoe4worldmobilewrapper.domain

import com.example.aoe4worldmobilewrapper.data.games.Games
import com.example.aoe4worldmobilewrapper.di.GamesApi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GamesUseCase @Inject constructor(
    private val gamesApi: GamesApi,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) {
    private val _games = MutableStateFlow<Games?>(null)
    val games: StateFlow<Games?> get() = _games

    suspend fun getGames(
        page: Int? = null,
        perPage: String? = "50",
        profileIds: List<Int>? = null,
        leaderboard: GameType? = null,
        since: String? = null, // Can be an integer or a datetime string
        updatedSince: String? = null, // Can be an integer or a datetime string
        order: String? = GamesOrder.started_at.name
    ) = withContext(dispatcher) {
        val response = gamesApi.getGames(
            page,
            perPage,
            profileIds?.joinToString(separator = ","),
            leaderboard?.name,
            since,
            updatedSince,
            order
        )
        if (response.isSuccessful) {
            response.body()?.let { body ->
                _games.value = body
            }
        } else {
            _games.value = null
        }
    }

    enum class GamesOrder {
        started_at, updated_at
    }

    enum class GameType {
        rm_1v1, qm_1v1, qm_2v2, qm_3v3, qm_4v4, rm_1v1_console, qm_1v1_console, qm_2v2_console, qm_3v3_console, qm_4v4_console
    }
}