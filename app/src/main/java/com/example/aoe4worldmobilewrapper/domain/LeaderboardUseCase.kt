package com.example.aoe4worldmobilewrapper.domain

import com.example.aoe4worldmobilewrapper.data.leaderboard.Leaderboard
import com.example.aoe4worldmobilewrapper.di.LeaderboardApi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LeaderboardUseCase @Inject constructor(
    private val leaderboardApi: LeaderboardApi,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) {
    private val _leaderboard = MutableStateFlow<Leaderboard?>(null)
    val leaderboard: StateFlow<Leaderboard?> get() = _leaderboard

    suspend fun getLeaderBoard(
        leaderBoardType: LeaderBoardTypes,
        page: Int? = null,
        query: String? = null,
        profileId: Int? = null
    ) = withContext(dispatcher) {
        val response = leaderboardApi.getLeaderboard(
            leaderBoardType.name.lowercase(),
            page,
            query,
            profileId
        )
        if (response.isSuccessful) {
            response.body()?.let { body ->
                _leaderboard.value = body
            }
        } else {
            _leaderboard.value = null
        }
    }

    enum class LeaderBoardTypes {
        QM_1v1,
        QM_2v2,
        QM_3v3,
        QM_4v4,
        RM_SOLO,
        RM_TEAM
    }
}