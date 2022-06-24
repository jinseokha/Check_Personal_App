package com.devseok.data.repository.remote.datasource

import com.devseok.data.remote.model.DataLoveResponse
import com.devseok.data.remote.model.DataScore
import com.devseok.domain.utils.RemoteErrorEmitter
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.Query
import com.google.firebase.firestore.QuerySnapshot

/**
 * @author Ha Jin Seok
 * @email seok270@gmail.com
 * @created 2022-06-16
 * @desc
 */
interface MainDataSource {

    // 궁합 API
    suspend fun checkLoveCalculator(
        remoteErrorEmitter: RemoteErrorEmitter,
        host : String,
        key : String,
        // fName = 남자 이름
        mName : String,

        // wName = 여자 이름
        wName : String
    ) : DataLoveResponse?

    // 통계 가져오기
    fun getStatistics() : Task<DataSnapshot>

    // 통계 저장하기
    fun setStatistics(plusValue : Int) : Task<Void>

    // 전적 가져오기
    fun getScore() : Task<QuerySnapshot>

    // 전적 저장하기
    fun setScore(score : DataScore) : Task<Void>
}