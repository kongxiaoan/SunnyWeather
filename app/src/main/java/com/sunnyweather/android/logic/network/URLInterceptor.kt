package com.sunnyweather.android.logic.network

import okhttp3.Interceptor
import okhttp3.Response

/**
 *    @projectName: SunnyWeather
 *    @ClassName : TestInterceptor
 *    author : kpa
 *    e-mail : kpa@super0.net
 *    @CreateDate   : 2020/6/113:01 PM
 *    @UpdateDate   : 2020/6/113:01 PM
 *    desc   : 对URL重定向，
 *    @UpdateRemark : 更新说明
 *    version: 1.0
 */
class URLInterceptor : Interceptor {
    private val newHost = "127.0.0.1"
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url
        val scheme = url.scheme
        val host = url.host
        val path = url.encodedPath
        val query = url.encodedQuery
        val sb = StringBuffer()
        val newUrl =
            sb.append(scheme).append(newHost).append(path).append("?").append(query).toString()
        val builder = request.newBuilder()
            .url(newUrl)
        return chain.proceed(builder.build())
    }
}