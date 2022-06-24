package com.devseok.check_personal_app.di

import com.devseok.data.remote.api.LoveCalculatorApi
import com.devseok.data.repository.remote.datasource.MainDataSource
import com.devseok.data.repository.remote.datasource.SplashDataSource
import com.devseok.data.repository.remote.datasourceImpl.MainDataSourceImpl
import com.devseok.data.repository.remote.datasourceImpl.SplashDataSourceImpl
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
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
class DataSourceModule {

    @Provides
    @Singleton
    fun provideMainDataSource(
        loveCalculatorApi: LoveCalculatorApi,
        firebaseRtdb: FirebaseDatabase,
        firebaseStore: FirebaseFirestore
    ) : MainDataSource {
        return MainDataSourceImpl(
            loveCalculatorApi,
            firebaseRtdb,
            firebaseStore
        )
    }

    @Provides
    @Singleton
    fun provideSplashDataSource(
        firebaseRtdb : FirebaseDatabase,
        firebaseStore : FirebaseFirestore
    ) : SplashDataSource {
        return SplashDataSourceImpl(
            firebaseRtdb, firebaseStore
        )
    }

}