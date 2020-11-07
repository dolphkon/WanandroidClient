package com.dolphkon.wanandroidclient;

import android.app.Application;
import android.content.Context;

import com.dolphkon.httplib.utils.HttplibConfig;


/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.wanandroidclient
 * ClassName：
 * Author: kongdexi
 * Date: 2020/10/29 15:41
 * Description:TODO
 * *****************************************************
 */
public class App extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext=this;
        HttplibConfig.init(this);



    }

    public static Context getContext() {
        return mContext;
    }
}
