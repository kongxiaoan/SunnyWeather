package com.sunnyweather.android.logic.dao

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sunnyweather.android.R

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


    fun getData() :MutableLiveData<List<String>>{
        // 返回珍视数据
        return MutableLiveData()
    }

    fun getBitmap(): LiveData<Bitmap> {
        val mutableLiveData = MutableLiveData<Bitmap>()
        val bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.wechatimg2)
        mutableLiveData.postValue(bitmap)
        return mutableLiveData
    }

    companion object {
        @Volatile
        private var instance: PictureRepository? = null
        fun getInstance(context: Context) = instance ?: synchronized(this) {
            instance ?: PictureRepository(context).also { instance = it }
        }
    }
}