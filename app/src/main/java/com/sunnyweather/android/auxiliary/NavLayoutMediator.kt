package com.sunnyweather.android.auxiliary

import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.sunnyweather.android.widget.NavLayout
import org.jetbrains.annotations.NotNull
import java.lang.ref.WeakReference

/**
 *    @projectName: SunnyWeather
 *    @ClassName : NavigationMediator
 *    author : kpa
 *    e-mail : kpa@super0.net
 *    @CreateDate   : 2020/6/138:20 PM
 *    @UpdateDate   : 2020/6/138:20 PM
 *    desc   : 使用中介者模式
 *    @UpdateRemark : 更新说明
 *    version: 1.0
 */
class NavLayoutMediator {
    private lateinit var viewPager: ViewPager2
    private lateinit var navLayout: NavLayout
    private lateinit var onConfigureNavCallback: OnConfigureNavCallback
    private lateinit var viewPagerOnNavSelectedListener: ViewPagerOnNavSelectedListener
    private lateinit var pageAdapterObserver: RecyclerView.AdapterDataObserver
    private var autoRefresh: Boolean = false
    private var attached = false

    private var adapter: RecyclerView.Adapter<*>? = null
    private lateinit var navLayoutOnPageChangeCallback: NavLayoutOnPageChangeCallback

    constructor(
        @NotNull viewPager: ViewPager2,
        @NotNull navLayout: NavLayout,
        @NotNull onConfigureNavCallback: OnConfigureNavCallback
    ) : this(viewPager, navLayout, true, onConfigureNavCallback)


    constructor(
        @NotNull viewPager: ViewPager2,
        @NotNull navLayout: NavLayout,
        @NotNull autoRefresh: Boolean,
        @NotNull onConfigureNavCallback: OnConfigureNavCallback
    ) {
        this.viewPager = viewPager
        this.navLayout = navLayout
        this.autoRefresh = autoRefresh
        this.onConfigureNavCallback = onConfigureNavCallback
    }

    fun attach() {
        if (attached) {
            throw IllegalStateException("NavigationMediator is already attached")
        }
        adapter = viewPager.adapter
        checkNotNull(adapter) { "NavigationMediator attached before ViewPager2 has an " + "adapter" }
        attached = true
        navLayoutOnPageChangeCallback = NavLayoutOnPageChangeCallback(navLayout)
        viewPager.registerOnPageChangeCallback(navLayoutOnPageChangeCallback)

        viewPagerOnNavSelectedListener = ViewPagerOnNavSelectedListener(viewPager)
        navLayout.registerOnNavSelectedListener(viewPagerOnNavSelectedListener)

        if (autoRefresh) {
            pageAdapterObserver = PageAdapterObserver()
            adapter.registerAdapterDataObserver(pageAdapterObserver)
        }
    }

    class PageAdapterObserver : RecyclerView.AdapterDataObserver() {
        override fun onChanged() {
            super.onChanged()
        }

        override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
            super.onItemRangeRemoved(positionStart, itemCount)
        }

        override fun onItemRangeMoved(fromPosition: Int, toPosition: Int, itemCount: Int) {
            super.onItemRangeMoved(fromPosition, toPosition, itemCount)
        }

        override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
            super.onItemRangeInserted(positionStart, itemCount)
        }

        override fun onItemRangeChanged(positionStart: Int, itemCount: Int) {
            super.onItemRangeChanged(positionStart, itemCount)
        }

        override fun onItemRangeChanged(positionStart: Int, itemCount: Int, payload: Any?) {
            super.onItemRangeChanged(positionStart, itemCount, payload)
        }
    }


    class ViewPagerOnNavSelectedListener(private var viewPager: ViewPager2) :
        NavLayout.OnNavSelectedListener {
        override fun onNavSelected(position: Int) {
            viewPager.currentItem = position
        }
    }

    class NavLayoutOnPageChangeCallback(navLayout: NavLayout) :
        ViewPager2.OnPageChangeCallback() {
        private val navLayoutRef: WeakReference<NavLayout> = WeakReference(navLayout)
        private var previousScrollState = 0
        private var scrollState = 0

        init {
            reset()
        }

        override fun onPageScrollStateChanged(state: Int) {
            super.onPageScrollStateChanged(state)
        }

        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
            super.onPageScrolled(position, positionOffset, positionOffsetPixels)
        }

        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            val navLayout = navLayoutRef.get()
            navLayout?.bindToViewPager(position)
        }

        private fun reset() {
            scrollState = ViewPager2.SCROLL_STATE_IDLE
            previousScrollState = scrollState
        }

    }

    interface OnConfigureNavCallback {
        fun onConfigureNav(nav: NavLayout.Nav, position: Int)
    }
}