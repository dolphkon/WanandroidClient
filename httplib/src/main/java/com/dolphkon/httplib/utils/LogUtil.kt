package com.dolphkon.httplib.utils

import com.dolphkon.httplib.BuildConfig
import com.orhanobut.logger.Logger

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.httplib.utils
 * ClassName：LogUtil
 * Author: kongdexi
 * Date: 2020/10/14 15:48
 * Description:TODO
 * *****************************************************
 */
object LogUtil {
    var isDebug = BuildConfig.DEBUG
    fun i(msg: String?) {
        if (isDebug) {
            Logger.i(msg!!)
        }
    }

    fun i(TAG: String, msg: String) {
        if (isDebug) {
            Logger.i("$TAG ==> $msg")
        }
    }

    fun v(msg: String?) {
        if (isDebug) {
            Logger.v(msg!!)
        }
    }

    fun e(msg: String?) {
        if (isDebug) {
            Logger.e(msg!!)
        }
    }

    fun d(msg: String?) {
        if (isDebug) {
            Logger.d(msg)
        }
    }

    fun w(msg: String?) {
        if (isDebug) {
            Logger.w(msg!!)
        }
    }

    fun v(TAG: String, msg: String) {
        if (isDebug) {
            Logger.v("$TAG ==> $msg")
        }
    }

    fun e(TAG: String, msg: String) {
        if (isDebug) {
            Logger.e("$TAG ==> $msg")
        }
    }

    fun d(TAG: String, msg: String) {
        if (isDebug) {
            Logger.d("$TAG ==> $msg")
        }
    }

    fun w(TAG: String, msg: String) {
        if (isDebug) {
            Logger.w("$TAG ==> $msg")
        }
    }

    fun json(msg: String?) {
        if (isDebug) {
            Logger.json(msg)
        }
    }
}