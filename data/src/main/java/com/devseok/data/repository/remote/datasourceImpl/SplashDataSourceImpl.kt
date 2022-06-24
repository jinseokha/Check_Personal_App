package com.devseok.data.repository.remote.datasourceImpl

import com.devseok.data.repository.remote.datasource.SplashDataSource
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import javax.inject.Inject

/**
 * @author Ha Jin Seok
 * @email seok270@gmail.com
 * @created 2022-06-16
 * @desc
 */
class SplashDataSourceImpl @Inject constructor(
  private val firebaseRtdb : FirebaseDatabase,
  private val fireStore : FirebaseFirestore
) : SplashDataSource {
    override fun checkAppVersion(): Task<DataSnapshot> {
        return firebaseRtdb.reference.child("version").get()
    }
}