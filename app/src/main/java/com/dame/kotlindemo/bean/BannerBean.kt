package com.dame.kotlindemo.bean

import java.io.Serializable

/**
 *created by 姚明亮
 *Time：2019/7/24 14:31
 */
data class BannerBean(val errorCode:Int,val errorMsg:String,val data:ArrayList<Data>):Serializable{
    data class Data(val imagePath:String):Serializable
}