package com.example.testfetchamazon.data

import retrofit2.http.GET

interface RewardApi {
    @GET("hiring.json")
    suspend fun getRewards(): List<RewardDto>
}
