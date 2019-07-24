package com.dame.kotlindemo.contract

import com.dame.kotlindemo.base.IBaseView
import com.dame.kotlindemo.bean.BannerBean

/**
 *created by 姚明亮
 *Time：2019/7/24 14:52
 */
interface HomoContract {

    interface HomeView:IBaseView{
        fun setHomeBanner(bean:BannerBean)
        fun showError(errorMsg: String, errorCode: Int)
    }

    interface HomeP{
        fun requestBanner()

        fun loadMoreData(page:String)
    }
}