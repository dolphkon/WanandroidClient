package com.dolphkon.wanandroidclient.net;

import android.content.Context;

import com.dolphkon.httplib.error.ErrorCode;
import com.dolphkon.httplib.error.RxException;
import com.dolphkon.httplib.utils.HttplibConfig;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.wanandroidclient.net
 * ClassName：NetWorkDetectedInterceptor
 * Author: kongdexi
 * Date: 2020/11/4 16:36
 * Description:TODO
 * *****************************************************
 */
public class NetWorkDetectedInterceptor implements Interceptor {

    private Context mContext;

    public NetWorkDetectedInterceptor(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        if (!HttplibConfig.isNetworkAvailable(mContext)) {
            throw new RxException(ErrorCode.ERROR_CODE_NO_NETWORK, "网络不可用,请检查网络设置是否正常");
        }
        return chain.proceed(chain.request());
    }
}