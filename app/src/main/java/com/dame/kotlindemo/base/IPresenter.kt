package com.dame.kotlindemo.base

/**
 *created by 姚明亮
 *Time：2019/7/19 15:12
 */
interface IPresenter<in V: IBaseView> {

    fun attachView(mRootView:V)

    fun detachView()

}