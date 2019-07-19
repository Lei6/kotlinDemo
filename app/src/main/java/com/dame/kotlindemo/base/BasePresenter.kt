package com.dame.kotlindemo.base

import io.reactivex.disposables.CompositeDisposable
import java.lang.RuntimeException

/**
 *created by 姚明亮
 *Time：2019/7/19 15:06
 */
open class BasePresenter<T : IBaseView> : IPresenter<T> {

    var mRootView: T? = null
        private set

    private var compositeDisponsable = CompositeDisposable()


    override fun detachView() {
        mRootView = null
        //activity结束时取消所有在执行的订阅
        if (!compositeDisponsable.isDisposed) {
            compositeDisponsable.clear()
        }

    }

    override fun attachView(mRootView: T) {
        this.mRootView = mRootView
    }

    private val isViewAttached: Boolean
        get() = mRootView != null

    fun checkViewAttached(){
        if (!isViewAttached)throw MvpViewNotAttachedException()
    }

    /**
     * 关键字constructor：在Java中，构造方法名须和类名相同；
     * 而在Kotlin中，是通过constructor关键字来标明的，
     * 且对于Primary Constructor（主构造器）而言，它的位置是在类的首部（class header）而不是在类体中（class body）。
     * 当constructor关键字没有注解和可见性修饰符作用于它时，constructor关键字可以省略（当然，如果有这些修饰时，是不能够省略的，并且constructor关键字位于修饰符后面）
     *
     * 关键字  internal 修饰符
     */
    private class MvpViewNotAttachedException internal constructor():RuntimeException("Please call IPresenter.attachView(IBaseView) before" + " requesting data to the IPresenter")

}