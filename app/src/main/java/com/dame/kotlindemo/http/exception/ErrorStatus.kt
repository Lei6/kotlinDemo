package com.dame.kotlindemo.http.exception

/**
 *created by 姚明亮
 *Time：2019/7/22 17:06
 *
 * 约定好的code
 *
 * 非 const 的属性 实际上为常量必须使用@JvmStatic 注解才能暴露为静态方法
 * const的效果等于@JvmField，两者不能同时使用
 */
object ErrorStatus {
    /**
     * 响应成功
     */
    @JvmField
    val SUCCESS = 0

    /**
     * 未知错误
     */
    @JvmField
    val UNKNOWN_ERROR = 1002

    /**
     * 服务器内部错误
     */
    @JvmField
    val SERVER_ERROR = 1003

    /**
     * 网络连接超时
     */
    @JvmField
    val NETWORK_ERROR = 1004

    /**
     * API解析异常（或者第三方数据结构更改）等其他异常
     */
    @JvmField
    val API_ERROR = 1005
}