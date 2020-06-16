package com.sunnyweather.android.widget

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.sunnyweather.android.R
import com.sunnyweather.android.utils.getScreenWidth

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
    private var navBackground = Color.WHITE
    private var normalColor = Color.BLACK
    private var selectColor = Color.BLUE

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        val ta = context?.obtainStyledAttributes(attrs, R.styleable.NavLayout)
        navBackground =
            ta?.getColor(R.styleable.NavLayout_navBackground, Color.WHITE) ?: Color.WHITE
        normalColor = ta?.getColor(R.styleable.NavLayout_normalColor, Color.BLACK) ?: Color.BLACK
        selectColor = ta?.getColor(R.styleable.NavLayout_selectColor, Color.BLUE) ?: Color.BLUE
        ta?.recycle()
    }

    init {
        /**
         * 可以是使用recyclerView 回调position ,利用position 更新adapter
         */
        val view = LayoutInflater.from(context).inflate(R.layout.nav_layout, this)
        val navRV = view.findViewById<RecyclerView>(R.id.navRV)
        initRv(navRV)
        bindEvent()
    }

    private fun bindEvent() {
        adapter.setOnItemClickListener { adapter, view, position ->
            Log.e("pos", "pos = $position")
            Toast.makeText(context, "fsfdsfdsfsd", Toast.LENGTH_LONG).show()
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
        this.mList.size
        for (i in 0 until this.mList.size) {
            this.mList[i].isSelect = position == i
        }
        adapter.notifyDataSetChanged()
    }

    fun addData(navList: MutableList<Nav>) {
        this.mList.clear()
        this.mList.addAll(navList)
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

    inner class NavLayoutAdapter(data: MutableList<Nav>) :
        BaseQuickAdapter<Nav, BaseViewHolder>(R.layout.nav_item, data) {
        override fun convert(holder: BaseViewHolder, item: Nav) {
            val screenWidth = getScreenWidth()
            val width = screenWidth / data.size
            val navItem = holder.getView<LinearLayout>(R.id.navItem)
            val navIv = holder.getView<ImageView>(R.id.navIv)
            val navName = holder.getView<TextView>(R.id.navName)
            val layoutParams = navItem.layoutParams
            layoutParams.width = width
            navItem.layoutParams = layoutParams
            val drawable = context.getDrawable(R.drawable.selector_nav_picture)
            navIv.setImageDrawable(drawable)
            navName.text = item.text
            navItem.setBackgroundColor(navBackground)
            if (item.isSelect) {
                navName.setTextColor(selectColor)
            } else {
                navName.setTextColor(normalColor)
            }
        }


    }

    class Nav(
        val icon: Int,
        val text: String,
        var isSelect: Boolean
    )
}