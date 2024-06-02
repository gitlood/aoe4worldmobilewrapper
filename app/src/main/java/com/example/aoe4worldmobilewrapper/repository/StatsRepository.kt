package com.example.aoe4worldmobilewrapper.repository

import com.example.aoe4worldmobilewrapper.data.stats.civilizations.Civilization
import com.example.aoe4worldmobilewrapper.data.stats.maps.Maps
import com.example.aoe4worldmobilewrapper.data.stats.matchups.Matchups
import com.example.aoe4worldmobilewrapper.di.StatsApi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class StatsRepository @Inject constructor(
    private val statsApi: StatsApi,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) {
    private val _civilizations = MutableStateFlow<Civilization?>(null)
    val civilization: StateFlow<Civilization?> get() = _civilizations

    private val _maps = MutableStateFlow<Maps?>(null)
    val maps: StateFlow<Maps?> get() = _maps

    private val _matchups = MutableStateFlow<Matchups?>(null)
    val matchups: StateFlow<Matchups?> get() = _matchups

    suspend fun getStatMapsRM(
        patch: String? = null,
        rankLevel: Int? = null,
        rating: String? = null
    ) = withContext(dispatcher) {
        val response = statsApi.getStatsMaps(
            gameType = GameTypesRM.rm_solo.name,
            patch = patch,
            rankLevel = rankLevel,
            rating = rating
        )
        if (response.isSuccessful) {
            response.body()?.let { body ->
                _maps.value = body
            }
        } else {
            _maps.value = null
        }
    }

    suspend fun getStatMapsQM(
        patch: String? = null,
        rating: String? = null
    ) = withContext(dispatcher) {
        val response =
            statsApi.getStatsMaps(
                gameType = GameTypesQM.qm_1v1.name,
                patch = patch,
                rating = rating
            )
        if (response.isSuccessful) {
            response.body()?.let { body ->
                _maps.value = body
            }
        } else {
            _maps.value = null
        }
    }

    suspend fun getStatCivilizationRM(
        gameType: GameTypesRM,
        patch: String? = null,
        rankLevel: Int? = null,
        rating: String? = null
    ) = withContext(dispatcher) {
        val response = statsApi.getStatsCivilizations(
            gameType = gameType.name,
            patch = patch,
            rankLevel = rankLevel,
            rating = rating
        )
        if (response.isSuccessful) {
            response.body()?.let { body ->
                _civilizations.value = body
            }
        } else {
            _civilizations.value = null
        }
    }

    suspend fun getStatCivilizationQM(
        gameType: GameTypesQM,
        patch: String? = null,
        rating: String? = null
    ) = withContext(dispatcher) {
        val response =
            statsApi.getStatsCivilizations(
                gameType = gameType.name,
                patch = patch,
                rating = rating
            )
        if (response.isSuccessful) {
            response.body()?.let { body ->
                _civilizations.value = body
            }
        } else {
            _civilizations.value = null
        }
    }

    suspend fun getStatMatchupsRM(
        gameType: GameTypesRM,
        patch: String? = null,
        rankLevel: Int? = null,
        rating: String? = null
    ) = withContext(dispatcher) {
        val response = statsApi.getStatsMatchups(
            gameType = gameType.name,
            patch = patch,
            rankLevel = rankLevel,
            rating = rating
        )
        if (response.isSuccessful) {
            response.body()?.let { body ->
                _matchups.value = body
            }
        } else {
            _matchups.value = null
        }
    }

    suspend fun getStatMatchupsQM(
        gameType: GameTypesQM,
        patch: String? = null,
        rating: String? = null
    ) = withContext(dispatcher) {
        val response =
            statsApi.getStatsMatchups(
                gameType = gameType.name,
                patch = patch,
                rating = rating
            )
        if (response.isSuccessful) {
            response.body()?.let { body ->
                _matchups.value = body
            }
        } else {
            _matchups.value = null
        }
    }


    enum class GameTypesRM {
        rm_team, rm_solo, rm_2v2, rm_3v3, rm_4v4
    }

    enum class GameTypesQM {
        qm_1v1, qm_2v2, qm_3v3, qm_4v4
    }
}