package com.dame.kotlindemo.http.exception

/**
 *created by 姚明亮
 *Time：2019/7/22 17:00
 */
class ApiException : RuntimeException{

    private var code:Int? = null

    constructor(throwable:Throwable,code:Int) : super(throwable){
        this.code = code
    }

    constructor(message: String?):super(Throwable(message))
}