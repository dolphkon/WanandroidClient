package com.dolphkon.httplib.utils;


import com.dolphkon.httplib.BuildConfig;
import com.orhanobut.logger.Logger;

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
public class LogUtil {
    static boolean isDebug = BuildConfig.DEBUG;

    public static void i(String msg) {
        if (isDebug) {
            Logger.i(msg);
        }
    }
    public static void i(String TAG,String msg) {
        if (isDebug) {
            Logger.i(TAG+" ==> "+msg);
        }
    }

    public static void v(String msg) {
        if (isDebug) {
            Logger.v(msg);
        }
    }

    public static void e(String msg) {
        if (isDebug) {
            Logger.e(msg);
        }
    }

    public static void d(String msg) {
        if (isDebug) {
            Logger.d(msg);
        }
    }

    public static void w(String msg) {
        if (isDebug) {
            Logger.w(msg);
        }
    }


    public static void v(String TAG, String msg) {
        if (isDebug) {
            Logger.v(TAG+" ==> "+msg);
        }
    }

    public static void e(String TAG, String msg) {
        if (isDebug) {
            Logger.e(TAG+" ==> "+msg);
        }
    }

    public static void d(String TAG, String msg) {
        if (isDebug) {
            Logger.d(TAG+" ==> "+msg);
        }
    }

    public static void w(String TAG, String msg) {
        if (isDebug) {
            Logger.w(TAG+" ==> "+msg);
        }
    }

    public static void json(String msg){
        if(isDebug){
            Logger.json(msg);
        }
    }

}
