package com.dame.kotlindemo


import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.dame.kotlindemo.activity.fragment.HomeFragment
import com.dame.kotlindemo.activity.fragment.MineFragment
import com.dame.kotlindemo.activity.fragment.SiteFragment

import com.dame.kotlindemo.base.BaseActivity
import com.dame.kotlindemo.bean.TabEntity
import com.dame.kotlindemo.utils.showToast
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : BaseActivity() {

    private var mIndex = 0
    private val mTitles = arrayOf("首页", "站点", "我的")
    private val mIconUnSelectIds = intArrayOf(R.mipmap.ic_home_normal, R.mipmap.ic_hot_normal, R.mipmap.ic_mine_normal)
    private val mIconSelectIds =
        intArrayOf(R.mipmap.ic_home_selected, R.mipmap.ic_hot_selected, R.mipmap.ic_mine_selected)
    private val mTabEntities = ArrayList<CustomTabEntity>()
    private var mExitTime: Long = 0
    private var mHomeFragment: HomeFragment? = null
    private var mSiteFragment: SiteFragment? = null
    private var mMineFragment: MineFragment? = null

    override fun layoutId(): Int = R.layout.activity_main

    override fun start() {
    }

    override fun initView() {
    }

    /**
     * 切换fragment
     */
    private fun switchFragment(position: Int) {
        Log.e("tml", "a$position")
        val transaction = supportFragmentManager.beginTransaction()
        hideFragments(transaction)
        when (position) {
            0 -> mHomeFragment?.let {
                transaction.show(it)
            } ?: HomeFragment.getInstance(mTitles[position]).let {
                mHomeFragment = it
                transaction.add(R.id.fl_container, it, "home")
            }
            1 -> mSiteFragment?.let {
                transaction.show(it)
            } ?: SiteFragment.getInstance(mTitles[position]).let {
                mSiteFragment = it
                transaction.add(R.id.fl_container, it, "site")
            }
            2 -> mMineFragment?.let {
                transaction.show(it)
            } ?: MineFragment.getInstance(mTitles[position]).let {
                mMineFragment = it
                transaction.add(R.id.fl_container, it, "site")
            }
            else -> {
            }
        }
        mIndex = position
        tab_layout.currentTab = mIndex
        transaction.commitAllowingStateLoss()
    }

    /**
     * 隐藏fragment
     */
    private fun hideFragments(transaction: FragmentTransaction) {
        mHomeFragment?.let {
            transaction.hide(it)
        }
        mSiteFragment?.let {
            transaction.hide(it)
        }
        mMineFragment?.let {
            transaction.hide(it)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (tab_layout != null) {
            outState.putInt("currTabIndex", mIndex)
        }
    }

    override fun initData() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            mIndex = savedInstanceState.getInt("currTabIndex")
        }
        super.onCreate(savedInstanceState)
        initTab()
        tab_layout.currentTab = mIndex
        switchFragment(mIndex)

    }

    private fun initTab() {
        /**
         * until  相当于闭区间 从0到size-1
         * mapTo将给定的变换函数应用于原始数组的每个元素，并将结果附加到给定目标。
         * */
        (0 until mTitles.size)
            .mapTo(mTabEntities) {
                TabEntity(mTitles[it], mIconSelectIds[it], mIconUnSelectIds[it])
            }
        //赋值给tab
        tab_layout.setTabData(mTabEntities)
        //监听
        tab_layout.setOnTabSelectListener(object : OnTabSelectListener {
            override fun onTabSelect(position: Int) {
                switchFragment(position)
            }

            override fun onTabReselect(position: Int) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis().minus(mExitTime) <= 2000) {
                finish()
            } else {
                mExitTime = System.currentTimeMillis()
                showToast("aa")
            }
            return true
        }

        return super.onKeyDown(keyCode, event)
    }
}
