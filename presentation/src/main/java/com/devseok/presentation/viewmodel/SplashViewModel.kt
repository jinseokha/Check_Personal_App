package com.devseok.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.devseok.domain.usecase.CheckAppVersionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @author Ha Jin Seok
 * @email seok270@gmail.com
 * @created 2022-06-16
 * @desc
 */
@HiltViewModel
class SplashViewModel @Inject constructor(
    private val checkAppVersionUseCase: CheckAppVersionUseCase
): ViewModel() {

    fun checkAppVersion() = checkAppVersionUseCase.execute()

}