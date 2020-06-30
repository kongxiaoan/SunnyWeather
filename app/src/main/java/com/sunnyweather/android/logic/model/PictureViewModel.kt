package com.sunnyweather.android.logic.model

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sunnyweather.android.logic.dao.PictureRepository

/**
 *    @projectName: SunnyWeather
 *    @ClassName : PictureViewModel
 *    author : kpa
 *    e-mail : kpa@super0.net
 *    @CreateDate   : 2020/6/135:26 PM
 *    @UpdateDate   : 2020/6/135:26 PM
 *    desc   :
 *    @UpdateRemark : 更新说明
 *    version: 1.0
 */
//internal 可见性修饰 统一模块中可见
class PictureViewModel internal constructor(repository: PictureRepository) : ViewModel(){
    val pictureView: MutableLiveData<List<String>> = repository.getData()
    val pictureBitmap: LiveData<Bitmap> = repository.getBitmap()
}