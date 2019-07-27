package com.dame.kotlindemo.contract

import com.dame.kotlindemo.base.IBaseView
import com.dame.kotlindemo.bean.BannerBean
import com.dame.kotlindemo.bean.HomeListBean

/**
 *created by 姚明亮
 *Time：2019/7/24 14:52
 */
interface HomoContract {

    interface HomeView:IBaseView{
        fun setHomeBanner(bean:BannerBean)
        fun showError(errorMsg: String, errorCode: Int)
        fun showHomeList(homeList:HomeListBean)
    }

    interface HomeP{
        fun requestBanner()

        fun loadMoreData(page:String)

        fun requestHomeList(page:String)
    }
}