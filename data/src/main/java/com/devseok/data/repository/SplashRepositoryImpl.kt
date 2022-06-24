package com.devseok.data.repository

import com.devseok.data.repository.remote.datasource.SplashDataSource
import com.devseok.domain.repository.SplashRepository
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import javax.inject.Inject

/**
 * @author Ha Jin Seok
 * @email seok270@gmail.com
 * @created 2022-06-16
 * @desc
 */
class SplashRepositoryImpl @Inject constructor(
  private val splashDataSource : SplashDataSource
) : SplashRepository {
    override fun checkAppVersion(): Task<DataSnapshot> {
        return splashDataSource.checkAppVersion()
    }
}