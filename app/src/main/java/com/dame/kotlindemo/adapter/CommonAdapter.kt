package com.dame.kotlindemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dame.kotlindemo.adapter.viewholder.MultipleType
import com.dame.kotlindemo.adapter.viewholder.OnItemClickListener
import com.dame.kotlindemo.adapter.viewholder.OnItemLongClickListener
import com.dame.kotlindemo.adapter.viewholder.ViewHolder

/**
 *created by 姚明亮
 *Time：2019/7/22 18:10
 *
 * 通用adapter
 */
abstract class CommonAdapter<T>(var mContext:Context,var mData:ArrayList<T>,private var mLayoutId:Int):
    RecyclerView.Adapter<ViewHolder>() {

    protected var mInflater:LayoutInflater? = null
    private var mTypeSupport: MultipleType<T>? = null

    /**
     * 接口回调点击事件
     */
    private var mItemClickListener: OnItemClickListener? = null
    private var mItemLongClickListener: OnItemLongClickListener? = null

    init {
        mInflater = LayoutInflater.from(mContext)
    }

    /**
     * 多布局
     */
    constructor(context: Context,data:ArrayList<T>,typeSupport: MultipleType<T>):this(context,data,-1){
        this.mTypeSupport = typeSupport
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (mTypeSupport!=null){
            //需要多布局
            mLayoutId = viewType
        }
        //创建view
        val view = mInflater?.inflate(mLayoutId,parent,false)
        return ViewHolder(view!!)
    }

    override fun getItemViewType(position: Int): Int {
        return mTypeSupport?.getLayoutId(mData[position],position)?:
                super.getItemViewType(position)
    }

    /**
     * 绑定数据
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        bindData(holder,mData[position],position)

        //点击事件   //1、实际上是一个作用域函数，定义一个变量在一个特定的作用域范围内 2、表示object不为null的条件下，才会去执行let函数体
        mItemClickListener?.let {
            holder.itemView.setOnClickListener {
                mItemClickListener!!.onItemClick(mData[position],position)
            }
        }

        mItemLongClickListener?.let {
            holder.itemView.setOnLongClickListener {
                mItemLongClickListener!!.onItemLongClick(mData[position],position)
            }
        }

    }

    abstract fun bindData(holder: ViewHolder, data: T, position: Int)

    override fun getItemCount(): Int {
        return mData.size
    }

    fun setOnItemClickListener(itemClickListener: OnItemClickListener) {
        this.mItemClickListener = itemClickListener
    }

    fun setOnItemLongClickListener(itemLongClickListener: OnItemLongClickListener) {
        this.mItemLongClickListener = itemLongClickListener
    }
}