package com.dolphkon.httpClient

import android.app.Application
import android.content.Context
import com.dolphkon.httplib.utils.HttplibManager.init

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.httpClient
 * ClassName：
 * Author: kongdexi
 * Date: 2020/10/29 15:41
 * Description:TODO
 * *****************************************************
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        context = this
        init(this)
    }

    companion object {
        lateinit var context: Context
            private set
    }
}