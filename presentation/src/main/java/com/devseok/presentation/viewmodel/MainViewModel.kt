package com.devseok.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devseok.domain.model.DomainLoveResponse
import com.devseok.domain.model.DomainScore
import com.devseok.domain.usecase.*
import com.devseok.domain.utils.ErrorType
import com.devseok.domain.utils.RemoteErrorEmitter
import com.devseok.domain.utils.ScreenState
import com.devseok.presentation.widget.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author Ha Jin Seok
 * @email seok270@gmail.com
 * @created 2022-06-16
 * @desc
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val checkLoveCalculatorUseCase: CheckLoveCalculatorUseCase,
    private val setStatisticsUseCase: SetStatisticsUseCase,
    private val getStatisticsUseCase: GetStatisticsUseCase,
    private val setScoreUseCase: SetScoreUseCase,
    private val getScoreUseCase: GetScoreUseCase
): ViewModel(), RemoteErrorEmitter {

    val apiCallEvent : LiveData<ScreenState>
        get () = _apiCallEvent

    private var _apiCallEvent = SingleLiveEvent<ScreenState>()

    val getStatisticsEvent : LiveData<Int>
        get () = _getStatisticsEvent

    private var _getStatisticsEvent = SingleLiveEvent<Int>()

    val getScoreEvent : LiveData<Int>
        get () = _getScoreEvent

    private var _getScoreEvent = SingleLiveEvent<Int>()


    var apiCallResult = DomainLoveResponse("", "", 0, "")
    var apiErrorType = ErrorType.UNKNOWN
    var apiErrorMessage = "none"

    var manNameResult = "man"
    var womanNameResult = "woman"

    var scoreList = arrayListOf<DomainScore>()

    /*fun checkLoveCalculator(host : String, key : String, mName : String, wName : String)
            = viewModelScope.launch {
        checkLoveCalculatorUseCase.execute(this@MainViewModel, host, key, mName, wName).let { response ->
            // 변환값이 잘 받아 올 때
            if (response != null) {
                apiCallResult = response
                _apiCallEvent.postValue(ScreenState.LOADING)
            } else {
                // 변환값이 null 일 때
                _apiCallEvent.postValue(ScreenState.ERROR)
            }
        }
    }*/

    fun checkLoveCalculator(host: String, key: String, mName: String, wName: String) =
        viewModelScope.launch {
            checkLoveCalculatorUseCase.execute(this@MainViewModel, host, key, mName, wName)
                .let { response ->
                    if (response != null) {
                        apiCallResult = response
                        _apiCallEvent.postValue(ScreenState.LOADING)
                    } else _apiCallEvent.postValue(ScreenState.ERROR)
                }
        }

    fun setStatistics(plusValue : Int) = setStatisticsUseCase.execute(plusValue)

    fun getStatistics() = getStatisticsUseCase.execute()

    fun getStatisticsDisplay() = getStatisticsUseCase.execute()
        .addOnSuccessListener {
            _getStatisticsEvent.value = it.value.toString().toInt()
        }

    fun getScore() = getScoreUseCase.execute()
        .addOnSuccessListener { snapshot ->
            scoreList.clear()
            for (item in snapshot.documents) {
                item.toObject(DomainScore::class.java).let {
                    scoreList.add(it!!)
                }
            }
            _getScoreEvent.call()
        }

    fun setScore(man : String, woman : String, percentage : Int, date : String) {
        setScoreUseCase.execute(DomainScore(man, woman, percentage, date))
    }

    override fun onError(msg: String) {
        apiErrorMessage = msg
    }

    override fun onError(errorType: ErrorType) {
        apiErrorType = errorType
    }


}