package com.dame.kotlindemo.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.youth.banner.loader.ImageLoader

/**
 *created by 姚明亮
 *Time：2019/7/24 16:02
 */
class GlideImageLoader : ImageLoader() {
    override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
        context?.let {
            imageView?.let {
                Glide.with(it).load(path).into(it)
            }
        }
    }
}