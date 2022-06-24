package com.devseok.domain.usecase

import com.devseok.domain.model.DomainScore
import com.devseok.domain.repository.MainRepository
import javax.inject.Inject

/**
 * @author Ha Jin Seok
 * @email seok270@gmail.com
 * @created 2022-06-20
 * @desc
 */
class GetScoreUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {

    fun execute() = mainRepository.getScore()

}