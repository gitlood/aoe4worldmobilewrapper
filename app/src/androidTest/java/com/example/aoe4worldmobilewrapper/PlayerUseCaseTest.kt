package com.example.aoe4worldmobilewrapper

import com.example.aoe4worldmobilewrapper.di.PlayerResource
import com.example.aoe4worldmobilewrapper.domain.PlayerUseCase
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
class PlayerUseCaseTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var playerResource: PlayerResource

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun testit() = runBlocking {
        val playerUseCase = PlayerUseCase(playerResource)
        playerUseCase.getMe()
    }
}