package com.devseok.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.devseok.domain.utils.ErrorType
import com.devseok.domain.utils.ScreenState
import com.devseok.presentation.R
import com.devseok.presentation.base.BaseFragment
import com.devseok.presentation.databinding.FragmentManNameBinding
import com.devseok.presentation.viewmodel.MainViewModel


class ManNameFragment : BaseFragment<FragmentManNameBinding>(R.layout.fragment_man_name) {

    private val mainViewModel by activityViewModels<MainViewModel>()

    override fun init() {
        binding.fragment = this

        observeViewModel()
    }

    fun nextBtnClick(view: View) {
        mainViewModel.manNameResult = binding.nameEditTxt.text.toString()
        binding.progressBar.visibility = View.VISIBLE
        mainViewModel.checkLoveCalculator(
            "love-calculator.p.rapidapi.com",
            "779fd54b0amsh91d38730c3435dcp1e9af3jsn7b22a22422c1",
            mainViewModel.manNameResult,
            mainViewModel.womanNameResult
        )

    }

    private fun observeViewModel() {
        mainViewModel.apiCallEvent.observe(this) {
            binding.progressBar.visibility = View.INVISIBLE
            when (it) {
                ScreenState.LOADING -> this.findNavController().navigate(R.id.action_mainNameFragment_to_resultFragment)
                ScreenState.ERROR -> toastErrorMsg()
                else -> shortShowToast("알 수 없는 오류가 발생했습니다.")
            }
        }
    }

    private fun toastErrorMsg() {
        when (mainViewModel.apiErrorType) {
            ErrorType.NETWORK -> longShowToast("네트워크 오류가 발생했습니다.")
            ErrorType.SESSION_EXPIRED -> longShowToast("세션이 만료되었습니다.")
            ErrorType.TIMEOUT -> longShowToast("호출 시간이 초과되었습니다.")
            ErrorType.UNKNOWN -> longShowToast("예기치 못한 오류가 발생했습니다.")
        }
    }
}