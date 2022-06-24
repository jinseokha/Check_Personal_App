package com.devseok.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.devseok.presentation.R
import com.devseok.presentation.adapter.ScoreRecyclerViewAdapter
import com.devseok.presentation.base.BaseFragment
import com.devseok.presentation.databinding.FragmentMainBinding
import com.devseok.presentation.viewmodel.MainViewModel
import com.devseok.presentation.widget.extension.showVertical
import com.pss.library.CountNumberEvent.Companion.countNumber


class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun init() {
        binding.fragment = this
        observeViewModel()
        mainViewModel.getStatisticsDisplay()
        mainViewModel.getScore()
    }

    fun startBtnClick(view: View) {
        this.findNavController().navigate(R.id.action_mainFragment_to_womanNameFragment)
    }

    private fun observeViewModel() {
        mainViewModel.getStatisticsEvent.observe(this) {
            countNumber(0, it, binding.statistics, 3000)

        }

        mainViewModel.getScoreEvent.observe(this) {
            initRecyclerView()
        }
    }

    private fun initRecyclerView() {
        binding.scroeRecyclerView.adapter = ScoreRecyclerViewAdapter(mainViewModel)
        binding.scroeRecyclerView.showVertical(requireContext())
    }
}