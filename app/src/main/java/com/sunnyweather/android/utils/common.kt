package com.sunnyweather.android.utils

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Point
import android.os.Build
import android.view.WindowManager
import com.sunnyweather.android.SunnyWeatherApplication

/**
 *    @projectName: SunnyWeather
 *    @ClassName : common
 *    author : kpa
 *    e-mail : kpa@super0.net
 *    @CreateDate   : 2020/6/1510:49 AM
 *    @UpdateDate   : 2020/6/1510:49 AM
 *    desc   :
 *    @UpdateRemark : 更新说明
 *    version: 1.0
 */

@SuppressLint("ObsoleteSdkInt")
fun getScreenWidth() :Int{
    val windowManager =
        SunnyWeatherApplication.context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            ?: return -1
    val point = Point()
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
        windowManager.defaultDisplay.getRealSize(point)
    } else {
        windowManager.defaultDisplay.getSize(point)
    }
    return point.x
}