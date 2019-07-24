package com.dame.kotlindemo.http

import com.dame.kotlindemo.bean.BannerBean
import io.reactivex.Observable
import retrofit2.http.GET

/**
 *created by 姚明亮
 *Time：2019/7/19 17:18
 */
interface ApiService {

    @GET("/banner/json")
    fun getBanner():Observable<BannerBean>
}