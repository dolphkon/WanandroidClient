package com.dolphkon.httplib.utils

import android.content.Context
import android.net.ConnectivityManager
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.FormatStrategy
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.httplib.utils
 * ClassName：
 * Author: kongdexi
 * Date: 2020/10/12 17:23
 * Description:TODO
 * *****************************************************
 */
object HttplibManager {
    var context: Context? = null
        private set

    @JvmStatic
    fun init(context: Context) {
        this.context = context.applicationContext
        val formatStrategy: FormatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)
                .build()
        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))
    }

    /**
     * check NetworkAvailable
     * @param context
     * @return
     */
    fun isNetworkAvailable(context: Context): Boolean {
        val manager = context.applicationContext.getSystemService(
                Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                ?: return false
        val info = manager.activeNetworkInfo
        return if (null == info || !info.isAvailable) false else true
    }
}