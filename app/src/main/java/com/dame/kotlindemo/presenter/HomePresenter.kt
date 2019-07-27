package com.dame.kotlindemo.presenter

import com.dame.kotlindemo.base.BasePresenter
import com.dame.kotlindemo.contract.HomoContract
import com.dame.kotlindemo.http.exception.ExceptionHandle
import com.dame.kotlindemo.model.HomeModel

/**
 *created by 姚明亮
 *Time：2019/7/24 15:07
 */
class HomePresenter : BasePresenter<HomoContract.HomeView>(), HomoContract.HomeP {
    override fun requestHomeList(page: String) {
        checkViewAttached()
//        mRootView?.showLoading()
        val disposable = homeModel.getHomeListData(page)
            .subscribe({
                    ass->
                mRootView?.apply {
                    hideLoading()
                    showHomeList(ass.data)
                }
            },{
                mRootView?.showError(ExceptionHandle.handleException(it),ExceptionHandle.errorCode)
            })

        addSubscription(disposable)

    }

    private val homeModel: HomeModel by lazy {
        HomeModel()
    }

    override fun requestBanner() {
        checkViewAttached()
        mRootView?.showLoading()
        val disposable = homeModel.getHomeBannerData()
            .subscribe({
                banner->
                mRootView?.apply {
                    hideLoading()
                    setHomeBanner(banner)
                }
            }, {
                mRootView?.apply {
                    showError(ExceptionHandle.handleException(it), ExceptionHandle.errorCode)
                }
            })
        addSubscription(disposable)
    }

    override fun loadMoreData(page: String) {
        checkViewAttached()
//        mRootView?.showLoading()
        val disposable = homeModel.getHomeListData(page)
            .subscribe({
                mRootView?.apply {
//                    hideLoading()
                    showHomeList(it.data)
                }
            },{
                mRootView?.showError(ExceptionHandle.handleException(it),ExceptionHandle.errorCode)
            })

        addSubscription(disposable)

    }
}