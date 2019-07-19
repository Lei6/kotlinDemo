package com.dame.kotlindemo.base

/**
 *created by 姚明亮
 *Time：2019/7/19 15:07
 */
interface IBaseView {

    /**
     * 显示loading
     */
    fun showLoading()

    /**
     * 隐藏loading
     */
    fun hideLoading()

    /**
     * 显示toast
     */
    fun showError(msg: String)
}