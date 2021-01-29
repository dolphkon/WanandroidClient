package com.dolphkon.httpClient;

import android.app.Application;
import android.content.Context;

import com.dolphkon.httplib.utils.HttplibManager;


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
public class App extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext=this;
        HttplibManager.init(this);



    }

    public static Context getContext() {
        return mContext;
    }
}
