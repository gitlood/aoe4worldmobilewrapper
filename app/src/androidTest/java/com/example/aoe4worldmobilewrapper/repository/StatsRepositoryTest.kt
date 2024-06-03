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
        statsRepository.getStatMatchupsRM()
        val matchups = statsRepository.matchups.value
        Assert.assertTrue(StatsRepository.GameTypesRM.rm_solo.name == matchups?.leaderboard)
    }

    @Test
    fun getStatMatchupsQMReturnsCorrectInfoSolo() = runTest {
        val statsRepository = StatsRepository(statsApi)
        statsRepository.getStatMatchupsQM()
        val matchups = statsRepository.matchups.value
        Assert.assertTrue(StatsRepository.GameTypesQM.qm_1v1.name == matchups?.leaderboard)
    }

    @Test
    fun getStatCivilizationsQMReturnsCorrectInfoSolo() = runTest {
        val statsRepository = StatsRepository(statsApi)
        statsRepository.getStatCivilizationQM(StatsRepository.GameTypesQM.qm_1v1)
        val civilizations = statsRepository.civilization.value
        Assert.assertTrue(StatsRepository.GameTypesQM.qm_1v1.name == civilizations?.leaderboard)
    }

    @Test
    fun getStatCivilizationsQMReturnsCorrectInfo2v2() = runTest {
        val statsRepository = StatsRepository(statsApi)
        statsRepository.getStatCivilizationQM(StatsRepository.GameTypesQM.qm_2v2)
        val civilizations = statsRepository.civilization.value
        Assert.assertTrue(StatsRepository.GameTypesQM.qm_2v2.name == civilizations?.kind)
    }

    @Test
    fun getStatCivilizationsQMReturnsCorrectInfo3v3() = runTest {
        val statsRepository = StatsRepository(statsApi)
        statsRepository.getStatCivilizationQM(StatsRepository.GameTypesQM.qm_3v3)
        val civilizations = statsRepository.civilization.value
        Assert.assertTrue(StatsRepository.GameTypesQM.qm_3v3.name == civilizations?.kind)
    }

    @Test
    fun getStatCivilizationsQMReturnsCorrectInfo4v4() = runTest {
        val statsRepository = StatsRepository(statsApi)
        statsRepository.getStatCivilizationQM(StatsRepository.GameTypesQM.qm_4v4)
        val civilizations = statsRepository.civilization.value
        Assert.assertTrue(StatsRepository.GameTypesQM.qm_4v4.name == civilizations?.kind)
    }

    @Test
    fun getStatCivilizationsRMReturnsCorrectInfoSolo() = runTest {
        val statsRepository = StatsRepository(statsApi)
        statsRepository.getStatCivilizationRM(StatsRepository.GameTypesRM.rm_solo)
        val civilizations = statsRepository.civilization.value
        Assert.assertTrue(StatsRepository.GameTypesRM.rm_solo.name == civilizations?.leaderboard)
    }
}