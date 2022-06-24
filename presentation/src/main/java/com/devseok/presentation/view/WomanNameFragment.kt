package com.devseok.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.devseok.presentation.R
import com.devseok.presentation.base.BaseFragment
import com.devseok.presentation.databinding.FragmentWomanNameBinding
import com.devseok.presentation.viewmodel.MainViewModel


class WomanNameFragment : BaseFragment<FragmentWomanNameBinding>(R.layout.fragment_woman_name) {

    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun init() {
        binding.fragment = this
    }

    fun nextBtnClick(view: View) {
        mainViewModel.womanNameResult = binding.nameEditTxt.text.toString()
        this.findNavController().navigate(R.id.action_womanNameFragment_to_mainNameFragment)
    }
}