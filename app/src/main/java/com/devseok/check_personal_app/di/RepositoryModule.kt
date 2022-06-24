package com.devseok.check_personal_app.di

import com.devseok.data.repository.MainRepositoryImpl
import com.devseok.data.repository.SplashRepositoryImpl
import com.devseok.data.repository.remote.datasource.MainDataSource
import com.devseok.data.repository.remote.datasource.SplashDataSource
import com.devseok.domain.repository.MainRepository
import com.devseok.domain.repository.SplashRepository
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
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMainRepository (
        mainDataSource: MainDataSource
    ) : MainRepository {
        return MainRepositoryImpl(
            mainDataSource
        )
    }

    @Provides
    @Singleton
    fun provideSplashRepository (
        splashDataSource: SplashDataSource
    ) : SplashRepository {
        return SplashRepositoryImpl(
            splashDataSource
        )
    }
}