package com.dolphkon.httplib.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

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
public class HttplibConfig {
private static Context mContext;
    public static void init(Context context) {
        mContext = context.getApplicationContext();


        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
    }
    public static Context getContext() {
        return mContext;
    }

    /**
     * check NetworkAvailable
     * @param context
     * @return
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getApplicationContext().getSystemService(
                Context.CONNECTIVITY_SERVICE);
        if (null == manager)
            return false;
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (null == info || !info.isAvailable())
            return false;
        return true;
    }


}
