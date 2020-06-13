package com.sunnyweather.android.utils

import com.sunnyweather.android.logic.network.URLInterceptor
import okhttp3.OkHttpClient

/**
 *    @projectName: SunnyWeather
 *    @ClassName : SHttp
 *    author : kpa
 *    e-mail : kpa@super0.net
 *    @CreateDate   : 2020/6/112:58 PM
 *    @UpdateDate   : 2020/6/112:58 PM
 *    desc   :
 *    @UpdateRemark : 更新说明
 *    version: 1.0
 */
object SNetworkHelper {

    val client: OkHttpClient.Builder by lazy {
        val builder = OkHttpClient.Builder()
        builder.addInterceptor(URLInterceptor())
        builder.build()
        builder
    }
}