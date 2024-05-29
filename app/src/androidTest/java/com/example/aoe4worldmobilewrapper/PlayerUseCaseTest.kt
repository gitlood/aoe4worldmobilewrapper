package com.example.aoe4worldmobilewrapper

import com.example.aoe4worldmobilewrapper.di.PlayerResource
import com.example.aoe4worldmobilewrapper.domain.PlayerUseCase
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
class PlayerUseCaseTest {

    private val myPlayerId = "9705268"
    private val myPlayerName = "Master Lood"
    private val myCountry = "nz"
    private val gameId = "130051922"

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var playerResource: PlayerResource

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun getPlayerForMyPlayerIdReturnsMyPlayerInfo() = runTest {
        val playerUseCase = PlayerUseCase(playerResource)
        playerUseCase.getPlayer(myPlayerId)
        val player = playerUseCase.player.value
        assertTrue(myPlayerName == player?.name)
        assertTrue(myCountry == player?.country)
    }

    @Test
    fun getPlayerReturnsNullWhenInvalidPlayerId() = runTest {
        val playerUseCase = PlayerUseCase(playerResource)
        playerUseCase.getPlayer("invalid")
        assertNull(playerUseCase.player.value)
    }

    @Test
    fun getPlayersGameForMyPlayerIdReturnsMyAListOfGames() = runTest {
        val playerUseCase = PlayerUseCase(playerResource)
        playerUseCase.getPlayersGame(myPlayerId)
        val games = playerUseCase.playersGames.value
        assertTrue(games?.filters?.profile_ids?.first() == myPlayerId.toInt())
        assertTrue(games?.games?.isNotEmpty() == true)
    }

    @Test
    fun getPlayersGameReturnsNullWhenInvalidPlayerId() = runTest {
        val playerUseCase = PlayerUseCase(playerResource)
        playerUseCase.getPlayersGame("invalid")
        assertNull(playerUseCase.playersGames.value)
    }

    @Test
    fun getPlayerGameForMyPlayerIdReturnsMyAListOfGames() = runTest {
        val playerUseCase = PlayerUseCase(playerResource)
        playerUseCase.getPlayerGame(myPlayerId, gameId)
        val game = playerUseCase.game.value
        assertTrue(game?.game_id.toString() == gameId)
    }

    @Test
    fun getPlayerGameReturnsNullWhenInvalidPlayerIdAndGameId() = runTest {
        val playerUseCase = PlayerUseCase(playerResource)
        playerUseCase.getPlayerGame("invalid", "invalid")
        assertNull(playerUseCase.playersGames.value)
    }

    @Test
    fun getPlayerLastGameWithStatsForMyPlayerIdReturnsGameWithStats() = runTest {
        val playerUseCase = PlayerUseCase(playerResource)
        playerUseCase.getPlayerLastGameWithStats(myPlayerId)
        val game = playerUseCase.gameWithStats.value
        assertTrue(game?.ongoing == false)
    }

    @Test
    fun getPlayerLastGameWithStatsReturnsNullWhenInvalidPlayerId() = runTest {
        val playerUseCase = PlayerUseCase(playerResource)
        playerUseCase.getPlayerLastGameWithStats("invalid")
        assertNull(playerUseCase.gameWithStats.value)
    }

    @Test
    fun searchPlayersForMyPlayerNameReturnMyPlayer() = runTest {
        val playerUseCase = PlayerUseCase(playerResource)
        playerUseCase.searchPlayers(myPlayerName)
        val game = playerUseCase.searchPlayers.value
        assertTrue(game?.players?.first()?.name == myPlayerName)
        assertTrue(game?.players?.size == 1)
    }

    @Test
    fun searchPlayersReturnsNullWhenInvalidPlayerName() = runTest {
        val playerUseCase = PlayerUseCase(playerResource)
        playerUseCase.searchPlayers("3904uv2m0935h8t928m345h298045ht,2-dh2y")
        val game = playerUseCase.searchPlayers.value
        assertTrue(game?.count == 0)
    }
}