package com.example.testfetchamazon.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testfetchamazon.databinding.ActivityRewardsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class RewardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRewardsBinding

    private val viewModel: RewardViewModel by viewModels()

    @Inject
    internal lateinit var rewardAdapter: RewardAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRewardsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding.rvRewardGroup) {
            adapter = rewardAdapter
            layoutManager = LinearLayoutManager(this@RewardActivity)
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.rewardUiState.collect {
                    rewardAdapter.submitList(it.rewards)
                    binding.progressCircular.isVisible = it.isLoading
                    it.error?.let { throwable ->
                        toast(throwable.message.orEmpty())
                    }
                }
            }
        }
    }
}