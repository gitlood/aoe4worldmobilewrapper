package com.example.aoe4worldmobilewrapper.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl("https://aoe4world.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun providesHttpClient(): OkHttpClient =
        OkHttpClient.Builder().build()

    @Provides
    @Singleton
    fun providesPlayerApiService(retrofit: Retrofit): PlayerApi = retrofit.create(
        PlayerApi::class.java
    )

    @Provides
    @Singleton
    fun providesLeaderboardApiService(retrofit: Retrofit): LeaderboardApi = retrofit.create(
        LeaderboardApi::class.java
    )
}
