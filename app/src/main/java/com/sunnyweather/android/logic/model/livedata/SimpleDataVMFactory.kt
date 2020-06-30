package com.sunnyweather.android.logic.model.livedata

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.Dispatchers

/**
 *    @projectName: SunnyWeather
 *    @ClassName : SimpleDataVMFactory
 *    author : kpa
 *    e-mail : kpa@super0.net
 *    @CreateDate   : 2020/6/2911:30 AM
 *    @UpdateDate   : 2020/6/2911:30 AM
 *    desc   :
 *    @UpdateRemark : 更新说明
 *    version: 1.0
 */
class SimpleDataVMFactory: ViewModelProvider.Factory {
   private val dataSource = SimpleDataSource(Dispatchers.IO)
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SimpleViewModel(dataSource) as T
    }
}