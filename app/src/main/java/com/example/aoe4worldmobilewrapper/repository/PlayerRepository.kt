package com.example.aoe4worldmobilewrapper.repository

import com.example.aoe4worldmobilewrapper.data.game.Game
import com.example.aoe4worldmobilewrapper.data.gamewithstats.GameWithStats
import com.example.aoe4worldmobilewrapper.data.player.Player
import com.example.aoe4worldmobilewrapper.data.playersgames.PlayersGames
import com.example.aoe4worldmobilewrapper.data.searchplayers.SearchPlayers
import com.example.aoe4worldmobilewrapper.di.PlayerApi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PlayerRepository @Inject constructor(
    private val playerApi: PlayerApi,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) {

    private val _player = MutableStateFlow<Player?>(null)
    val player: StateFlow<Player?> get() = _player

    private val _playersGames = MutableStateFlow<PlayersGames?>(null)
    val playersGames: StateFlow<PlayersGames?> get() = _playersGames

    private val _game = MutableStateFlow<Game?>(null)
    val game: StateFlow<Game?> get() = _game

    private val _gameWithStats = MutableStateFlow<GameWithStats?>(null)
    val gameWithStats: StateFlow<GameWithStats?> get() = _gameWithStats

    private val _searchPlayers = MutableStateFlow<SearchPlayers?>(null)
    val searchPlayers: StateFlow<SearchPlayers?> get() = _searchPlayers

    suspend fun getPlayer(playerId: String) = withContext(dispatcher) {
        val response = playerApi.getPlayer(playerId)
        if (response.isSuccessful) {
            response.body()?.let { body ->
                _player.value = body
            }
        } else {
            _player.value = null
        }
    }

    suspend fun getPlayersGame(
        playerId: String,
        page: Int? = null,
        limit: Int? = null,
        leaderBoard: String? = null,
        opponentProfileId: Int? = null,
        since: String? = null,
        includeAlts: Boolean? = null,
    ) = withContext(dispatcher) {
        val response = playerApi.getPlayerGames(playerId, page, limit, leaderBoard, opponentProfileId, since, includeAlts)
        if (response.isSuccessful) {
            response.body()?.let { body ->
                _playersGames.value = body
            }
        } else {
            _playersGames.value = null
        }
    }

    suspend fun getPlayerGame(
        profileId: String,
        gameId: String,
        includeAlts: Boolean? = null,
    ) = withContext(dispatcher) {
        val response = playerApi.getPlayerGame(profileId, gameId, includeAlts)
        if (response.isSuccessful) {
            response.body()?.let { body ->
                _game.value = body
            }
        } else {
            _game.value = null
        }
    }

    suspend fun getPlayerLastGameWithStats(
        profileId: String,
        includeAlts: Boolean? = null,
        includeStats: Boolean? = null,
    ) = withContext(dispatcher) {
        val response = playerApi.getPlayerLastGameWithStats(profileId, includeAlts, includeStats)
        if (response.isSuccessful) {
            response.body()?.let { body ->
                _gameWithStats.value = body
            }
        } else {
            _gameWithStats.value = null
        }
    }

    suspend fun searchPlayers(
        profileId: String,
        page: Int? = null,
        exact: Boolean? = null,
    ) = withContext(dispatcher) {
        val response = playerApi.searchPlayers(profileId, page, exact)
        if (response.isSuccessful) {
            response.body()?.let { body ->
                _searchPlayers.value = body
            }
        } else {
            _searchPlayers.value = null
        }
    }
}