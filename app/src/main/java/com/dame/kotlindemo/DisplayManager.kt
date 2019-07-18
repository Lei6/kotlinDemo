package com.dame.kotlindemo

import android.content.Context
import android.util.DisplayMetrics


/**
 *
 */
object DisplayManager {

    //android 提供DisplayMetircs 类可以很方便的获取分辨率,通用信息，如显示大小，分辨率和字体。

    private var displayMetrics: DisplayMetrics? = null
    private var screenWidth: Int? = null
    private var screenHeight: Int? = null
    private var screenDpi: Int? = null

    /**
     * 初始化代码可以放在初始化代码段中，初始化代码段使用 init 关键字作为前缀
     * 主构造器中不能包含任何代码
     *
     * ?.表示空执行
     * !!.表示不为空的情况下执行
     */
    fun init(context: Context) {
        displayMetrics = context.resources.displayMetrics
        screenWidth = displayMetrics?.widthPixels
        screenHeight = displayMetrics?.heightPixels
        screenDpi = displayMetrics?.densityDpi
    }

    /**
     * UI图大小
     */
    private const val STANDARD_WIDTH = 1080
    private const val STANDARD_HEIGHT = 1920

    //带返回值的方法    无返回值Int改为Unit，相当于java中的void
    fun getScreenWidth(): Int? {
        return screenWidth
    }

    fun getScreenHeight(): Int? {
        return screenHeight
    }

    /**
     * 传入UI图中问题的高度，单位像素
     * toByte(): Byte
     * toShort(): Short
     * toInt(): Int
     * toLong(): Long
     * toFloat(): Float
     * toDouble(): Double
     * toChar(): Char
     */
    fun getPaintSize(size: Int): Int? {
        return getRealHeight(size)
    }

    /**
     * 输入UI图的尺寸，输出实际的px
     *
     * @param px ui图中的大小
     * @param parentWidth 父view在ui图中的高度
     * @return
     */
    fun getRealWidth(px: Int, parentWidth: Float): Int? {
        //ui图的宽度
        return getRealWidth(px, STANDARD_WIDTH.toFloat())
    }

    fun getRealHeight(px: Int): Int? {
        return getRealHeight(px, STANDARD_HEIGHT.toFloat())
    }

    /**
     * 输入UI图的尺寸，输出实际的px,第二个参数是父布局
     *
     * @param px           ui图中的大小
     * @param parentHeight 父view在ui图中的高度
     * @return
     */
    fun getRealHeight(px: Int, parentHeight: Float): Int? {
        return (px / parentHeight * getScreenHeight()!!).toInt()
    }


    /**
     * dip转px
     */
    fun dip2px(dipValue: Float): Int? {
        val scale = displayMetrics?.density
        return (dipValue * scale!! + 0.5f).toInt()
    }
}