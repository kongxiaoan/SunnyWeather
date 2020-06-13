package com.sunnyweather.android.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sunnyweather.android.ui.main.MainFragment
import com.sunnyweather.android.ui.pisture.PictureFragment
import com.sunnyweather.android.ui.place.PlaceFragment
import java.lang.IndexOutOfBoundsException

/**
 *    @projectName: SunnyWeather
 *    @ClassName : MainAdapter
 *    author : kpa
 *    e-mail : kpa@super0.net
 *    @CreateDate   : 2020/6/136:10 PM
 *    @UpdateDate   : 2020/6/136:10 PM
 *    desc   :
 *    @UpdateRemark : 更新说明
 *    version: 1.0
 */
const val PLACE_INDEX = 0
const val PICTURE_INDEX = 1

class MainAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val tabFragmentsCreators: Map<Int, () -> Fragment> = mapOf(
        PLACE_INDEX to { PlaceFragment() },
        PICTURE_INDEX to { PictureFragment() }
    )

    override fun getItemCount() = tabFragmentsCreators.size

    override fun createFragment(position: Int): Fragment {
        return tabFragmentsCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}