package com.sunnyweather.android.logic.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sunnyweather.android.logic.dao.PictureRepository

/**
 *    @projectName: SunnyWeather
 *    @ClassName : PictureViewModelFactory
 *    author : kpa
 *    e-mail : kpa@super0.net
 *    @CreateDate   : 2020/6/135:36 PM
 *    @UpdateDate   : 2020/6/135:36 PM
 *    desc   :
 *    @UpdateRemark : 更新说明
 *    version: 1.0
 */
@Suppress("UNCHECKED_CAST")
class PictureViewModelFactory(private val repository: PictureRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PictureViewModel(repository) as T
    }
}