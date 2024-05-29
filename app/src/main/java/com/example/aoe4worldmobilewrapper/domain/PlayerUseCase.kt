package com.example.aoe4worldmobilewrapper.domain

import com.example.aoe4worldmobilewrapper.data.player.Player
import com.example.aoe4worldmobilewrapper.data.playersgames.PlayersGames
import com.example.aoe4worldmobilewrapper.di.PlayerResource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PlayerUseCase @Inject constructor(
    private val playerResource: PlayerResource,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    private val _player = MutableStateFlow<Player?>(null)
    val player: StateFlow<Player?> get() = _player

    private val _playersGames = MutableStateFlow<PlayersGames?>(null)
    val playersGames: StateFlow<PlayersGames?> get() = _playersGames

    suspend fun getPlayer(playerId: String) = withContext(dispatcher) {
        val response = playerResource.getPlayer(playerId)
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
        includeAlts: Boolean? = null
    ) = withContext(dispatcher) {
        val response = playerResource.getPlayerGames(playerId, page, limit, leaderBoard, opponentProfileId, since, includeAlts)
        if (response.isSuccessful) {
            response.body()?.let { body ->
                _playersGames.value = body
            }
        } else {
            _playersGames.value = null
        }
    }
}