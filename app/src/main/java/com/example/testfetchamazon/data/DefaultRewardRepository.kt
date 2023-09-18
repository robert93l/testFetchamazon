package com.example.testfetchamazon.data


import com.example.testfetchamazon.domain.Reward
import com.example.testfetchamazon.domain.RewardRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class DefaultRewardRepository @Inject constructor(
    private val rewardApi: RewardApi,
    private val ioDispatcher: CoroutineDispatcher,
) : RewardRepository {
    override fun getRewards(): Flow<List<Reward>> = flow {
        emit(
            rewardApi.getRewards()
                .map(RewardDto::toReward)
        )
    }
        .flowOn(ioDispatcher)
}
