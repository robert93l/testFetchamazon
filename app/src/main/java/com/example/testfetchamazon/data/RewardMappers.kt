package com.example.testfetchamazon.data

import com.example.testfetchamazon.domain.Reward

fun RewardDto.toReward() = Reward(
    id = id,
    listId = listId,
    name = name
)
