package com.sunnyweather.android.utils

import android.content.Context
import com.sunnyweather.android.logic.dao.PictureRepository
import com.sunnyweather.android.logic.model.PictureViewModelFactory

/**
 *    @projectName: SunnyWeather
 *    @ClassName : InjectorUtils
 *    author : kpa
 *    e-mail : kpa@super0.net
 *    @CreateDate   : 2020/6/135:38 PM
 *    @UpdateDate   : 2020/6/135:38 PM
 *    desc   :
 *    @UpdateRemark : 更新说明
 *    version: 1.0
 */
object InjectorUtils {
    fun providerPictureViewModelFactory(context: Context) :PictureViewModelFactory {
        return PictureViewModelFactory(getPictureRepository(context))
    }

    private fun getPictureRepository(context: Context): PictureRepository {
        return PictureRepository.getInstance(context.applicationContext)
    }
}