package com.dame.kotlindemo

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.Log
import com.squareup.leakcanary.RefWatcher
import kotlin.properties.Delegates

//  ┏┓　　　┏┓
//┏┛┻━━━┛┻┓
//┃　　　　　　　┃
//┃　　　━　　　┃
//┃　┳┛　┗┳　┃
//┃　　　　　　　┃
//┃　　　┻　　　┃
//┃　　　　　　　┃
//┗━┓　　　┏━┛
//    ┃　　　┃   神兽保佑
//    ┃　　　┃   代码无BUG！
//    ┃　　　┗━━━┓
//    ┃　　　　　　　┣┓
//    ┃　　　　　　　┏┛
//    ┗┓┓┏━┳┓┏┛
//      ┃┫┫　┃┫┫
//      ┗┻┛　┗┻┛


/**
created by 姚明亮
Time：14:48
 */
class MyApplication : Application() {

    private var refWatcher: RefWatcher? = null

    companion object {
        private val TAG = "MyApplication"

        var context: Context by Delegates.notNull()
            private set

        fun getRefWatcher(context: Context): RefWatcher? {
            val myActivity = context.applicationContext as MyApplication
            return myActivity.refWatcher
        }
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        initConfig()
        DisplayManager.init(this)
        registerActivityLifecycleCallbacks(mActivityLifecycleCallbacks)
    }

    /**
     * 初始化配置
     */
    private fun initConfig() {

    }

    private val mActivityLifecycleCallbacks = object : Application.ActivityLifecycleCallbacks{
        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
            Log.d(TAG, "onCreated: " + activity.componentName.className)
        }

        override fun onActivityStarted(activity: Activity) {
            Log.d(TAG, "onStart: " + activity.componentName.className)
        }

        override fun onActivityResumed(activity: Activity) {

        }

        override fun onActivityPaused(activity: Activity) {

        }

        override fun onActivityStopped(activity: Activity) {

        }

        override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

        }

        override fun onActivityDestroyed(activity: Activity) {
            Log.d(TAG, "onDestroy: " + activity.componentName.className)
        }

    }

}