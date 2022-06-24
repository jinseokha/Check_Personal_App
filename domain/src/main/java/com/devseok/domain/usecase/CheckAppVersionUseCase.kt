package com.devseok.domain.usecase

import com.devseok.domain.repository.SplashRepository
import javax.inject.Inject

/**
 * @author Ha Jin Seok
 * @email seok270@gmail.com
 * @created 2022-06-16
 * @desc
 */
class CheckAppVersionUseCase @Inject constructor(
    private val splashRepository: SplashRepository
) {
  fun execute() = splashRepository.checkAppVersion()

}