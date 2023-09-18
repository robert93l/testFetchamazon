package com.example.testfetchamazon.presentation

import com.example.testfetchamazon.domain.Reward

data class RewardUiState(
    val isLoading: Boolean = false,
    val rewards: List<Reward> = emptyList(),
    val error: Throwable? = null
)