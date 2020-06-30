package com.sunnyweather.android.logic.model.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

/**
 *    @projectName: SunnyWeather
 *    @ClassName : SimpleDataSource
 *    author : kpa
 *    e-mail : kpa@super0.net
 *    @CreateDate   : 2020/6/288:34 PM
 *    @UpdateDate   : 2020/6/288:34 PM
 *    desc   :
 *    @UpdateRemark : 更新说明
 *    version: 1.0
 */

class SimpleDataSource internal constructor(private val ioDispatcher: CoroutineDispatcher): SimpleDataSourceImp{
    private val weatherConditions = listOf("Sunny", "Cloudy", "Rainy", "Stormy", "Snowy")
    private val _cachedData = MutableLiveData("this is old data, To show the cache")

    override fun getCurrentTime(): LiveData<Long> = liveData {
        while (true) {
            emit(System.currentTimeMillis())
            delay(1000)
        }
    }

    override fun fetchWeather(): LiveData<String> = liveData {
        var counter = 0
        while (true) {
            counter++
            delay(2000)
            emit(weatherConditions[counter % weatherConditions.size])
        }
    }

    override val cachedData: LiveData<String>
        get() = _cachedData

    override suspend fun fetchNewData() {
        withContext(Dispatchers.Main) {
            _cachedData.value = "加载新的数据"
            _cachedData.value = newData()
        }
    }
    private var counter = 0
    private suspend fun newData(): String = withContext(ioDispatcher) {
        delay(3000)
        counter++
        "New data $counter"
    }
}