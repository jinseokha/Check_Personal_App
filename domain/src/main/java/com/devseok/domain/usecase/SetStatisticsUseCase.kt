package com.devseok.domain.usecase

import com.devseok.domain.repository.MainRepository
import javax.inject.Inject

/**
 * @author Ha Jin Seok
 * @email seok270@gmail.com
 * @created 2022-06-20
 * @desc
 */
class SetStatisticsUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {

    fun execute(plusValue : Int) = mainRepository.setStatistics(plusValue)
}