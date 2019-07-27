package com.dame.kotlindemo.model

import com.dame.kotlindemo.bean.BannerBean
import com.dame.kotlindemo.bean.HomeListBean
import com.dame.kotlindemo.http.HttpRequest
import com.dame.kotlindemo.http.RetrofitManager
import com.hazz.kotlinmvp.rx.scheduler.SchedulerUtils
import io.reactivex.Observable

/**
 *created by 姚明亮
 *Time：2019/7/24 15:12
 */
class HomeModel {

    fun getHomeBannerData(): Observable<BannerBean> {
        return RetrofitManager.service.getBanner()
            .compose(SchedulerUtils.ioToMain())
    }

    fun getHomeListData(num:String):Observable<HttpRequest<HomeListBean>>{
        return RetrofitManager.service.getHomeList(num)
            .compose(SchedulerUtils.ioToMain())
    }

}