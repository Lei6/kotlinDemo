package com.dame.kotlindemo.http

import java.io.Serializable

/**
 *created by 姚明亮
 *Time：2019/7/27 10:15
 */
data class HttpRequest<T>(val data:T):Serializable