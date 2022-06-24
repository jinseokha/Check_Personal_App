package com.devseok.data.repository.remote.datasource

import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot

/**
 * @author Ha Jin Seok
 * @email seok270@gmail.com
 * @created 2022-06-16
 * @desc
 */
interface SplashDataSource {
    fun checkAppVersion() : Task<DataSnapshot>
}