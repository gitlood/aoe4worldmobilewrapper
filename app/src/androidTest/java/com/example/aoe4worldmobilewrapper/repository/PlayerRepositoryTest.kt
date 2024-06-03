package com.example.aoe4worldmobilewrapper.repository

import com.example.aoe4worldmobilewrapper.di.PlayerApi
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltAndroidTest
class PlayerRepositoryTest {

    private val myPlayerId = "9705268"
    private val myPlayerName = "Master Lood"
    private val myCountry = "nz"
    private val gameId = "130051922"

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var playerApi: PlayerApi

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun getPlayerForMyPlayerIdReturnsMyPlayerInfo() = runTest {
        val playerRepository = PlayerRepository(playerApi)
        playerRepository.getPlayer(myPlayerId)
        val player = playerRepository.player.value
        assertTrue(myPlayerName == player?.name)
        assertTrue(myCountry == player?.country)
    }

    @Test
    fun getPlayerReturnsNullWhenInvalidPlayerId() = runTest {
        val playerRepository = PlayerRepository(playerApi)
        playerRepository.getPlayer("invalid")
        assertNull(playerRepository.player.value)
    }

    @Test
    fun getPlayersGameForMyPlayerIdReturnsMyAListOfGames() = runTest {
        val playerRepository = PlayerRepository(playerApi)
        playerRepository.getPlayersGame(myPlayerId)
        val games = playerRepository.playersGames.value
        assertTrue(games?.filters?.profile_ids?.first() == myPlayerId.toInt())
        assertTrue(games?.games?.isNotEmpty() == true)
    }

    @Test
    fun getPlayersGameReturnsNullWhenInvalidPlayerId() = runTest {
        val playerRepository = PlayerRepository(playerApi)
        playerRepository.getPlayersGame("invalid")
        assertNull(playerRepository.playersGames.value)
    }

    @Test
    fun getPlayerGameForMyPlayerIdReturnsMyAListOfGames() = runTest {
        val playerRepository = PlayerRepository(playerApi)
        playerRepository.getPlayerGame(myPlayerId, gameId)
        val game = playerRepository.game.value
        assertTrue(game?.game_id.toString() == gameId)
    }

    @Test
    fun getPlayerGameReturnsNullWhenInvalidPlayerIdAndGameId() = runTest {
        val playerRepository = PlayerRepository(playerApi)
        playerRepository.getPlayerGame("invalid", "invalid")
        assertNull(playerRepository.playersGames.value)
    }

    @Test
    fun getPlayerLastGameWithStatsForMyPlayerIdReturnsGameWithStats() = runTest {
        val playerRepository = PlayerRepository(playerApi)
        playerRepository.getPlayerLastGameWithStats(myPlayerId)
        val game = playerRepository.gameWithStats.value
        assertTrue(game?.ongoing == false)
    }

    @Test
    fun getPlayerLastGameWithStatsReturnsNullWhenInvalidPlayerId() = runTest {
        val playerRepository = PlayerRepository(playerApi)
        playerRepository.getPlayerLastGameWithStats("invalid")
        assertNull(playerRepository.gameWithStats.value)
    }

    @Test
    fun searchPlayersForMyPlayerNameReturnMyPlayer() = runTest {
        val playerRepository = PlayerRepository(playerApi)
        playerRepository.searchPlayers(myPlayerName)
        val game = playerRepository.searchPlayers.value
        assertTrue(game?.players?.first()?.name == myPlayerName)
        assertTrue(game?.players?.size == 1)
    }

    @Test
    fun searchPlayersReturnsNullWhenInvalidPlayerName() = runTest {
        val playerRepository = PlayerRepository(playerApi)
        playerRepository.searchPlayers("3904uv2m0935h8t928m345h298045ht,2-dh2y")
        val game = playerRepository.searchPlayers.value
        assertTrue(game?.count == 0)
    }
}