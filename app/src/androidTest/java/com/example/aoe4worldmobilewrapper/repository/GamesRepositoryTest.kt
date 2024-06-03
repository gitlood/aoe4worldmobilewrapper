package com.example.aoe4worldmobilewrapper.repository

import com.example.aoe4worldmobilewrapper.di.GamesApi
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltAndroidTest
class GamesRepositoryTest {

    private val profileIds = listOf(9705268, 7132008, 7245221)


    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var gamesApi: GamesApi

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun getGamesFor3Teams() = runTest {
        val gamesRepository = GamesRepository(gamesApi)
        gamesRepository.getGames(
           profileIds = profileIds
        )
        val games = gamesRepository.games.value
        Assert.assertTrue(games?.games?.first()?.teams?.size == 2)
    }
}