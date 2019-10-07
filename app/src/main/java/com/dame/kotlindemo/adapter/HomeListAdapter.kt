package com.dame.kotlindemo.adapter

import android.content.Context
import android.view.View
import android.widget.Toast
import com.dame.kotlindemo.R
import com.dame.kotlindemo.adapter.viewholder.ViewHolder
import com.dame.kotlindemo.bean.HomeListBean

/**
 *created by 姚明亮
 *Time：2019/7/27 10:12
 */
class HomeListAdapter(mContext: Context, homeList: ArrayList<HomeListBean.DataBean>, layout: Int) :
    CommonAdapter<HomeListBean.DataBean>(mContext, homeList, layout) {

    /**
     *设置新数据
     */
    fun setData(homeList: ArrayList<HomeListBean.DataBean>) {
        mData.addAll(homeList)
        notifyDataSetChanged()
    }

    override fun bindData(holder: ViewHolder, data: HomeListBean.DataBean, position: Int) {
        holder.setText(R.id.tv_title,"${data.title}")
        holder.setText(R.id.tv_auc,"作者：${data.author}")
        holder.setText(R.id.tv_time,"时间：${data.niceDate}")
        holder.setOnItemClickListener(View.OnClickListener {
            Toast.makeText(mContext,"${data.title}",Toast.LENGTH_LONG).show()
        })
    }
}