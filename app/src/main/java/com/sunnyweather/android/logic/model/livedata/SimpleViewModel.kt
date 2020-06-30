package com.sunnyweather.android.logic.model.livedata

import androidx.lifecycle.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

/**
 *    @projectName: SunnyWeather
 *    @ClassName : SimpleViewModel
 *    author : kpa
 *    e-mail : kpa@super0.net
 *    @CreateDate   : 2020/6/288:28 PM
 *    @UpdateDate   : 2020/6/288:28 PM
 *    desc   :
 *    @UpdateRemark : 更新说明
 *    version: 1.0
 */
class SimpleViewModel internal constructor(val simpleDataSource: SimpleDataSourceImp) : ViewModel() {
    val currentTime = simpleDataSource.getCurrentTime()

    val currentTimeTransFormed = currentTime.switchMap {
        liveData { emit(timeStampToTime(it)) }
    }
    val currentWeather: LiveData<String> = liveData {
        emit(LOADING_STRING)
        emitSource(simpleDataSource.fetchWeather())
    }

    val cachedValue = simpleDataSource.cachedData

    fun onRefresh() {
        viewModelScope.launch {
            simpleDataSource.fetchNewData()
        }
    }

    private suspend fun timeStampToTime(timestamp: Long): String {
        delay(500)
        val date = Date(timestamp)
        return date.toString()
    }
    companion object {
        // Real apps would use a wrapper on the result type to handle this.
        const val LOADING_STRING = "Loading..."
    }
}