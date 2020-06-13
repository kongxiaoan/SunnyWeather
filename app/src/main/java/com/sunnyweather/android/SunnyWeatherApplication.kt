package com.sunnyweather.android

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/**
 *    @projectName: SunnyWeather
 *    @ClassName : SunnyWeatherApplication
 *    author : kpa
 *    e-mail : kpa@super0.net
 *    @CreateDate   : 2020/6/108:40 PM
 *    @UpdateDate   : 2020/6/108:40 PM
 *    desc   :
 *    @UpdateRemark : 更新说明
 *    version: 1.0
 */
class SunnyWeatherApplication: Application() {
    companion object{
        @SuppressLint("StaticFieldLeak")
        lateinit var context:Context
        const val TOKEN = "X1dSWIEzEgc8cGEP"
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}