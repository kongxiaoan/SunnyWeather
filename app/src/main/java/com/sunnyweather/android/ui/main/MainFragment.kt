package com.sunnyweather.android.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sunnyweather.android.R
import com.sunnyweather.android.auxiliary.NavLayoutMediator
import com.sunnyweather.android.databinding.FragmentViewPagerBinding
import com.sunnyweather.android.ui.adapter.MainAdapter
import com.sunnyweather.android.widget.NavLayout
import kotlinx.android.synthetic.main.fragment_view_pager.view.*


class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mainBinding = FragmentViewPagerBinding.inflate(inflater, container, false)
        val mainNav = mainBinding.mainNav
        val mainVp = mainBinding.mainVp
        mainVp.adapter = MainAdapter(this)
        NavLayoutMediator(mainVp,mainNav,object :NavLayoutMediator.OnConfigureNavCallback{
            override fun onConfigureNav(nav: NavLayout.Nav, position: Int) {
            }
            override fun navData(): MutableList<NavLayout.Nav> {
                val list = arrayListOf<NavLayout.Nav>()
                list.add(NavLayout.Nav(R.drawable.selector_nav_picture,"图片", true))
                list.add(NavLayout.Nav(R.drawable.selector_nav_picture,"视频", true))
                list.add(NavLayout.Nav(R.drawable.selector_nav_picture,"音乐", true))
                list.add(NavLayout.Nav(R.drawable.selector_nav_picture,"我的", false))
                return list
            }
        }).attach()
        return mainBinding.root
    }

}