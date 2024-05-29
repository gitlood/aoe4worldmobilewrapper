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
}