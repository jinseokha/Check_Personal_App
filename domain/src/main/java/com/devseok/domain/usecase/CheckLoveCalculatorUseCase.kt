package com.devseok.domain.usecase

import com.devseok.domain.model.DomainLoveResponse
import com.devseok.domain.repository.MainRepository
import com.devseok.domain.utils.RemoteErrorEmitter
import javax.inject.Inject

/**
 * @author Ha Jin Seok
 * @email seok270@gmail.com
 * @created 2022-06-16
 * @desc
 */
class CheckLoveCalculatorUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {
    suspend fun execute(remoteErrorEmitter: RemoteErrorEmitter, host : String, key : String, mName : String, wName : String)
        = mainRepository.checkLoveCalculator(remoteErrorEmitter, host, key, mName, wName)
}