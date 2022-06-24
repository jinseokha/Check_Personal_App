package com.devseok.data.repository

import com.devseok.data.mapper.MainMapper
import com.devseok.data.repository.remote.datasource.MainDataSource
import com.devseok.domain.model.DomainScore
import com.devseok.domain.model.DomainLoveResponse
import com.devseok.domain.repository.MainRepository
import com.devseok.domain.utils.RemoteErrorEmitter
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.firestore.QuerySnapshot
import javax.inject.Inject

/**
 * @author Ha Jin Seok
 * @email seok270@gmail.com
 * @created 2022-06-16
 * @desc
 */
class MainRepositoryImpl @Inject constructor(
    private val mainDataSource : MainDataSource
) : MainRepository {

    /*override suspend fun checkLoveCalculator(
        remoteErrorEmitter: RemoteErrorEmitter,
        host: String,
        key: String,
        mName: String,
        wName: String
    ): DomainLoveResponse? {
        return MainMapper.loveMapper(mainDataSource.checkLoveCalculator(remoteErrorEmitter, host, key, mName, wName))
    }*/

    override suspend fun checkLoveCalculator(remoteErrorEmitter: RemoteErrorEmitter, host : String, key : String, mName : String, wName : String): DomainLoveResponse? {
        return MainMapper.loveMapper(mainDataSource.checkLoveCalculator(remoteErrorEmitter = remoteErrorEmitter, host = host, key = key, mName = mName, wName = wName))
    }

    override fun getStatistics(): Task<DataSnapshot> {
        return mainDataSource.getStatistics()
    }

    override fun setStatistics(plusValue: Int): Task<Void> {
        return mainDataSource.setStatistics(plusValue)
    }

    override fun getScore(): Task<QuerySnapshot> {
        return mainDataSource.getScore()
    }

    override fun setScore(score: DomainScore): Task<Void> {
        return mainDataSource.setScore(MainMapper.scoreMapper(score))
    }
}