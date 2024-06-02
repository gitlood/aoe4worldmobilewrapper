package com.example.aoe4worldmobilewrapper.repository

import com.example.aoe4worldmobilewrapper.di.StatsApi
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
class StatsRepositoryTest {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var statsApi: StatsApi

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun getStatMapsRMReturnsCorrectInfoSolo() = runTest {
        val statsRepository = StatsRepository(statsApi)
        statsRepository.getStatMapsRM()
        val maps = statsRepository.maps.value
        Assert.assertTrue(StatsRepository.GameTypesRM.rm_solo.name == maps?.leaderboard)
    }

    @Test
    fun getStatMapsQMReturnsCorrectInfoSolo() = runTest {
        val statsRepository = StatsRepository(statsApi)
        statsRepository.getStatMapsQM()
        val maps = statsRepository.maps.value
        Assert.assertTrue(StatsRepository.GameTypesQM.qm_1v1.name == maps?.leaderboard)
    }

    @Test
    fun getStatMatchupsRMReturnsCorrectInfoSolo() = runTest {
        val statsRepository = StatsRepository(statsApi)
        statsRepository.getStatMatchupsRM(StatsRepository.GameTypesRM.rm_solo)
        val matchups = statsRepository.matchups.value
        Assert.assertTrue(StatsRepository.GameTypesRM.rm_solo.name == matchups?.leaderboard)
    }

    @Test
    fun getStatMatchupsQMReturnsCorrectInfoSolo() = runTest {
        val statsRepository = StatsRepository(statsApi)
        statsRepository.getStatMatchupsQM(StatsRepository.GameTypesQM.qm_1v1)
        val matchups = statsRepository.matchups.value
        Assert.assertTrue(StatsRepository.GameTypesQM.qm_1v1.name == matchups?.leaderboard)
    }
}