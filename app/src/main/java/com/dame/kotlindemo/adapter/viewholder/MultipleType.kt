package com.dame.kotlindemo.adapter.viewholder

/**
 *created by 姚明亮
 *Time：2019/7/22 17:57
 *
 * in 表示在**内
 *
 * 多条目布局类型
 */
interface MultipleType <in T>{
    fun getLayoutId(item:T,position:Int):Int
}