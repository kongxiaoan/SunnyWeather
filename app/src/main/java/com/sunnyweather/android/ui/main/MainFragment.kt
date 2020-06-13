package com.sunnyweather.android.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sunnyweather.android.databinding.FragmentViewPagerBinding
import com.sunnyweather.android.ui.adapter.MainAdapter


class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mainBinding = FragmentViewPagerBinding.inflate(inflater, container, false)
        val mainNav = mainBinding.mainNav
        val mainVp = mainBinding.mainVp

        mainVp.adapter = MainAdapter(this)

        return mainBinding.root
    }

}