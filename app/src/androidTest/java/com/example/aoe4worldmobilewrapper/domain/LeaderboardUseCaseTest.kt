package com.example.aoe4worldmobilewrapper.domain

import com.example.aoe4worldmobilewrapper.di.LeaderboardApi
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltAndroidTest
class LeaderboardUseCaseTest {

    private val myPlayerId = 9705268
    private val myQuery = "Master_Lood"
    private val myPlayerName = "Master Lood"

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var leaderboardApi: LeaderboardApi

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun getLeaderBoardForMyPlayerIdRM_SOLO() = runTest {
        val leaderboardUseCase = LeaderboardUseCase(leaderboardApi)
        leaderboardUseCase.getLeaderBoard(
            leaderBoardType = LeaderboardUseCase.LeaderBoardTypes.RM_SOLO,
            profileId = myPlayerId
        )
        val leaderboard = leaderboardUseCase.leaderboard.value
        assertTrue(myPlayerName == leaderboard?.players?.first()?.name)
        assertTrue("RM Solo" == leaderboard?.name)
    }

    @Test
    fun getLeaderBoardForMyPlayerIdRM_Team() = runTest {
        val leaderboardUseCase = LeaderboardUseCase(leaderboardApi)
        leaderboardUseCase.getLeaderBoard(
            leaderBoardType = LeaderboardUseCase.LeaderBoardTypes.RM_TEAM,
            query = myQuery
        )
        val leaderboard = leaderboardUseCase.leaderboard.value
        assertTrue(myPlayerName == leaderboard?.players?.first()?.name)
        assertTrue("RM Team" == leaderboard?.name)
    }

    @Test
    fun getLeaderBoardForMyPlayerIdQM_1v1() = runTest {
        val leaderboardUseCase = LeaderboardUseCase(leaderboardApi)
        leaderboardUseCase.getLeaderBoard(
            leaderBoardType = LeaderboardUseCase.LeaderBoardTypes.QM_1v1,
            profileId = myPlayerId
        )
        val leaderboard = leaderboardUseCase.leaderboard.value
        assertTrue("Quick Match 1v1" == leaderboard?.short_name)
    }

    @Test
    fun getLeaderBoardForMyPlayerIdQM_2v2() = runTest {
        val leaderboardUseCase = LeaderboardUseCase(leaderboardApi)
        leaderboardUseCase.getLeaderBoard(
            leaderBoardType = LeaderboardUseCase.LeaderBoardTypes.QM_2v2,
            profileId = myPlayerId
        )
        val leaderboard = leaderboardUseCase.leaderboard.value
        assertTrue("Quick Match 2v2" == leaderboard?.short_name)
    }

    @Test
    fun getLeaderBoardForMyPlayerIdQM_3v3() = runTest {
        val leaderboardUseCase = LeaderboardUseCase(leaderboardApi)
        leaderboardUseCase.getLeaderBoard(
            leaderBoardType = LeaderboardUseCase.LeaderBoardTypes.QM_3v3,
            page = 1,
            profileId = myPlayerId
        )
        val leaderboard = leaderboardUseCase.leaderboard.value
        assertTrue("QM 3v3" == leaderboard?.name)
    }

    @Test
    fun getLeaderBoardForMyPlayerIdQM_4v4() = runTest {
        val leaderboardUseCase = LeaderboardUseCase(leaderboardApi)
        leaderboardUseCase.getLeaderBoard(
            leaderBoardType = LeaderboardUseCase.LeaderBoardTypes.QM_4v4,
            profileId = myPlayerId
        )
        val leaderboard = leaderboardUseCase.leaderboard.value
        assertTrue("QM 4v4" == leaderboard?.name)
    }
}
