package com.devseok.check_personal_app.di

import com.devseok.domain.repository.MainRepository
import com.devseok.domain.repository.SplashRepository
import com.devseok.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author Ha Jin Seok
 * @email seok270@gmail.com
 * @created 2022-06-16
 * @desc
 */
@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideCheckLoveCalculatorUseCase(repository : MainRepository)
            = CheckLoveCalculatorUseCase(repository)

    @Provides
    @Singleton
    fun provideCheckAppVersionUseCase(repository : SplashRepository)
            = CheckAppVersionUseCase(repository)

    @Provides
    @Singleton
    fun provideGetStatisticsUseCase(repository : MainRepository)
            = GetStatisticsUseCase(repository)

    @Provides
    @Singleton
    fun provideSetStatisticsUseCase(repository : MainRepository)
            = SetStatisticsUseCase(repository)

    @Provides
    @Singleton
    fun provideSetScoreUseCase(repository : MainRepository)
            = SetScoreUseCase(repository)

    @Provides
    @Singleton
    fun provideGetScoreUseCase(repository : MainRepository)
            = GetScoreUseCase(repository)
}