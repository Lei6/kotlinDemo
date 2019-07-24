package com.dame.kotlindemo.activity.fragment

import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.dame.kotlindemo.R
import com.dame.kotlindemo.base.BaseFragment
import com.dame.kotlindemo.bean.BannerBean
import com.dame.kotlindemo.contract.HomoContract
import com.dame.kotlindemo.presenter.HomePresenter
import com.dame.kotlindemo.utils.GlideImageLoader
import com.youth.banner.BannerConfig
import com.youth.banner.loader.ImageLoader
import com.youth.banner.loader.ImageLoaderInterface
import kotlinx.android.synthetic.main.fragment_home.*
import kotlin.math.log

/**
 *created by 姚明亮
 *Time：2019/7/24 11:12
 */
class HomeFragment : BaseFragment(), HomoContract.HomeView {

    private var isRefresh = false
    private val mPresenter by lazy { HomePresenter() }
    private val glideImageLoader by lazy { GlideImageLoader() }

    private var imagList = ArrayList<String>()

    override fun setHomeBanner(bean: BannerBean) {
        bean.data.forEach {
            imagList.add(it.imagePath)
        }
        banner.setImageLoader(glideImageLoader)
        banner.setImages(imagList)
        banner.isAutoPlay(true)
        banner.setIndicatorGravity(BannerConfig.CENTER)
        banner.start()
    }


    override fun showError(errorMsg: String, errorCode: Int) {
    }

    override fun showLoading() {
        if (!isRefresh) {
            isRefresh = false
            mLayoutStatusView?.showLoading()
        }
    }

    override fun hideLoading() {
    }

    override fun showError(msg: String) {

    }

    private var mTitle: String? = null

    companion object {
        fun getInstance(title: String): HomeFragment {
            val fragment = HomeFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            fragment.mTitle = title
            return fragment
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun initView() {
        mPresenter.attachView(this)
    }

    override fun lazyLoad() {
        mPresenter.requestBanner()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }
}