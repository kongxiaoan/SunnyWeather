package com.sunnyweather.android.logic.model.livedata

import androidx.lifecycle.LiveData

/**
 *    @projectName: SunnyWeather
 *    @ClassName : SimpleDataSource
 *    author : kpa
 *    e-mail : kpa@super0.net
 *    @CreateDate   : 2020/6/288:30 PM
 *    @UpdateDate   : 2020/6/288:30 PM
 *    desc   :
 *    @UpdateRemark : 更新说明
 *    version: 1.0
 */
interface SimpleDataSourceImp {
    fun getCurrentTime(): LiveData<Long>
    fun fetchWeather(): LiveData<String>
    val cachedData: LiveData<String>
    suspend fun fetchNewData()
}