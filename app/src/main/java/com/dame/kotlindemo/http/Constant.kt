package com.dame.kotlindemo.http

/**
 *created by 姚明亮
 *Time：2019/7/19 17:30
 *
 * object声明一个类时，该类自动成为一个简单的单例模式
 * object声明的类，无法在外部用new的方式重新实例化
 * object 关键字可以表达两种含义：一种是对象表达式,另一种是 对象声明。
 */
object Constant {
    /**
     * const只能修饰常量val
     * const只能在object类中或者伴生对象companion object中使用
     * const的效果等于@JvmField，两者不能同时使用
     */
    const val BASE_URL = "https://www.wanandroid.com"
}