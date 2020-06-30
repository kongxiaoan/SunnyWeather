package com.sunnyweather.android

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.sunnyweather.android.databinding.ActivityTestLiveDataBinding
import com.sunnyweather.android.logic.model.livedata.SimpleDataVMFactory
import com.sunnyweather.android.logic.model.livedata.SimpleViewModel

class TestLiveDataActivity : AppCompatActivity() {

    private val simpleViewModel: SimpleViewModel by viewModels {
        SimpleDataVMFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataBinding = DataBindingUtil.setContentView<ActivityTestLiveDataBinding>(
            this,
            R.layout.activity_test_live_data
        )
        dataBinding.lifecycleOwner = this
        dataBinding.viewModel = simpleViewModel
    }

    companion object {
        fun startLiveData(context: Context) {
            context.startActivity(Intent(context, TestLiveDataActivity::class.java))
        }
    }
}