package com.dame.kotlindemo.activity.fragment

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator
import com.bumptech.glide.Glide
import com.dame.kotlindemo.R
import com.dame.kotlindemo.adapter.HomeListAdapter
import com.dame.kotlindemo.base.BaseFragment
import com.dame.kotlindemo.bean.BannerBean
import com.dame.kotlindemo.bean.HomeListBean
import com.dame.kotlindemo.contract.HomoContract
import com.dame.kotlindemo.presenter.HomePresenter
import com.dame.kotlindemo.utils.GlideImageLoader
import com.dame.kotlindemo.utils.StatusBarUtil
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
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

    private var itemList = ArrayList<HomeListBean.DataBean>()
    private val mAdapter by lazy { activity?.let { HomeListAdapter(it,itemList,R.layout.item_home_list) } }
    private var imagList = ArrayList<String>()

    private var loadingMore = false

    private var page = 0

    override fun showHomeList(homeList: HomeListBean) {
        loadingMore = false
        itemList = homeList.datas
        mAdapter?.setData(itemList)
    }


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
        multipleStatusView.showContent()
        mRefreshLayout.finishRefresh()
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

        home_recycle.adapter = mAdapter
        home_recycle.layoutManager = LinearLayoutManager(activity)
        home_recycle.itemAnimator = DefaultItemAnimator()

        mRefreshLayout.setOnRefreshListener {
            mPresenter.requestHomeList("0")
        }

        home_recycle.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                val itemCount = home_recycle.layoutManager?.itemCount
                val lastVisibleItem = (home_recycle.layoutManager as LinearLayoutManager).findLastVisibleItemPosition()
                if (itemCount != null) {
                    if (!loadingMore && lastVisibleItem == (itemCount - 1)) {
                        page++
                        loadingMore = true
                        mPresenter.loadMoreData(page.toString())
                    }
                }
            }
        })
        mLayoutStatusView = multipleStatusView

    }

    override fun lazyLoad() {
        mPresenter.requestBanner()
        mPresenter.requestHomeList(page.toString())
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }
}