package com.example.testfetchamazon.di

import com.example.testfetchamazon.data.DefaultRewardRepository
import com.example.testfetchamazon.domain.RewardRepository
import com.example.testfetchamazon.data.RewardApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.CoroutineDispatcher
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object RewardModule {
    @Provides
    fun provideRewardApi(retrofit: Retrofit): RewardApi = retrofit.create(RewardApi::class.java)

    @Provides
    fun provideRewardRepository(
        rewardApi: RewardApi,
        @IoDispatcher ioDispatcher: CoroutineDispatcher
    ): RewardRepository = DefaultRewardRepository(rewardApi, ioDispatcher)
}
