package com.dame.kotlindemo.bean

import java.io.Serializable

/**
 *created by 姚明亮
 *Time：2019/7/27 09:39
 */
data class HomeListBean(val datas:ArrayList<DataBean>):Serializable{
    data class DataBean(val author:String,val collect:String,val niceDate:String,val title:String):Serializable
}