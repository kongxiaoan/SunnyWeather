package com.sunnyweather.android.logic.dao

import android.content.Context

/**
 *    @projectName: SunnyWeather
 *    @ClassName : PictureRepository
 *    author : kpa
 *    e-mail : kpa@super0.net
 *    @CreateDate   : 2020/6/135:28 PM
 *    @UpdateDate   : 2020/6/135:28 PM
 *    desc   :
 *    @UpdateRemark : 更新说明
 *    version: 1.0
 */
class PictureRepository private constructor(private val context: Context) {



    companion object {
        @Volatile
        private var instance: PictureRepository? = null
        fun getInstance(context: Context) = instance ?: synchronized(this) {
            instance ?: PictureRepository(context).also { instance = it }
        }
    }
}