package com.dame.kotlindemo.activity.fragment

import android.os.Bundle
import com.dame.kotlindemo.R
import com.dame.kotlindemo.base.BaseFragment

/**
 *created by 姚明亮
 *Time：2019/7/24 11:13
 */
class SiteFragment : BaseFragment(){

    private var mTitle:String?  = null
    companion object {
        fun getInstance(title: String): SiteFragment {
            val fragment = SiteFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title
            return fragment
        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_site

    override fun initView() {
    }

    override fun lazyLoad() {
    }
}