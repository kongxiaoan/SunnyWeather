package com.sunnyweather.android.widget

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.sunnyweather.android.R

/**
 *    @projectName: SunnyWeather
 *    @ClassName : NavLayout
 *    author : kpa
 *    e-mail : kpa@super0.net
 *    @CreateDate   : 2020/6/138:41 PM
 *    @UpdateDate   : 2020/6/138:41 PM
 *    desc   :
 *    @UpdateRemark : 更新说明
 *    version: 1.0
 */
class NavLayout : ConstraintLayout {
    private var mList = arrayListOf<Nav>()
    private var adapter: NavLayoutAdapter = NavLayoutAdapter(mList)
    private var onNavSelectedListener: OnNavSelectedListener? = null

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        /**
         * 可以是使用recyclerView 回调position ,利用position 更新adapter
         */
        val view = LayoutInflater.from(context).inflate(R.layout.nav_layout, this)
        val navRV = view.findViewById<RecyclerView>(R.id.navRV)
        initRv(navRV)
        bindEvent(navRV)
    }

    private fun bindEvent(navRV: RecyclerView?) {
        checkNotNull(navRV) { "RecyclerView is null" }
        adapter.setOnItemClickListener { adapter, view, position ->
            checkNotNull(onNavSelectedListener) { "NavLayout.OnNavSelectedListener is null" }
            onNavSelectedListener?.onNavSelected(position)
        }
    }

    fun registerOnNavSelectedListener(onNavSelectedListener: OnNavSelectedListener) {
        this.onNavSelectedListener = onNavSelectedListener
    }

    fun unRegisterOnNavSelectedListener() {
        this.onNavSelectedListener = null
    }

    fun bindToViewPager(position: Int) {
        // 切换壮体
        adapter.notifyDataSetChanged()
    }

    private fun initRv(navRV: RecyclerView?) {
        checkNotNull(navRV) { "RecyclerView is null" }
        navRV.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        navRV.adapter = adapter
    }

    interface OnNavSelectedListener {
        fun onNavSelected(position: Int)
    }

    class NavLayoutAdapter(data: MutableList<Nav>) :
        BaseQuickAdapter<Nav, BaseViewHolder>(R.layout.nav_layout, data) {
        override fun convert(holder: BaseViewHolder, item: Nav) {

        }

    }

    class Nav(
        val icon: Drawable,
        val text: String,
        val isSelect: Boolean
    )
}