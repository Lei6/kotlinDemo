package com.dame.kotlindemo.activity.fragment

import android.os.Bundle
import com.dame.kotlindemo.R
import com.dame.kotlindemo.base.BaseFragment

/**
 *created by 姚明亮
 *Time：2019/7/24 11:14
 */
class MineFragment : BaseFragment(){

    private var mTitle:String?  = null
    companion object {
        fun getInstance(title: String): MineFragment {
            val fragment = MineFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title
            return fragment
        }
    }

    override fun getLayoutId(): Int  = R.layout.fragment_mine

    override fun initView() {
    }

    override fun lazyLoad() {
     }
}