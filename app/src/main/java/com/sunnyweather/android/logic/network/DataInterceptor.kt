package com.sunnyweather.android.logic.network

import okhttp3.Interceptor
import okhttp3.Response

/**
 *    @projectName: SunnyWeather
 *    @ClassName : DataInterceptor
 *    author : kpa
 *    e-mail : kpa@super0.net
 *    @CreateDate   : 2020/6/113:08 PM
 *    @UpdateDate   : 2020/6/113:08 PM
 *    desc   :
 *    @UpdateRemark : 更新说明
 *    version: 1.0
 */
class DataInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url
        val queryParameterNames = url.queryParameterNames
        val iterator = queryParameterNames.iterator()
        val sb = StringBuffer()
        queryParameterNames.forEach {
            val queryName = iterator.next()
            sb.append(queryName).append("=")
            val queryParameter = url.queryParameter(queryName)
            sb.append("进行加密操作")
            if (iterator.hasNext()) {
                sb.append("&")
            }
        }

        val newUrl = sb.toString()
        val builder = request.newBuilder()
            .url(newUrl)

        return chain.proceed(builder.build())
    }
}