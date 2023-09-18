package com.example.testfetchamazon.domain

import kotlinx.coroutines.flow.Flow

interface RewardRepository {
    fun getRewards(): Flow<List<Reward>>
}