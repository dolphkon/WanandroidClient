package com.dolphkon.wanandroidclient.net;

import com.dolphkon.httplib.utils.HttplibConfig;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.dolphkon.wanandroidclient.net.Constant.BASE_URL;

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.wanandroidclient.net
 * ClassName：RetrofitClient
 * Author: kongdexi
 * Date: 2020/10/30 9:28
 * Description:TODO
 * *****************************************************
 */
public class RetrofitClient {

    private static final int DEFAULT_TIMEOUT = 60;
    private final Retrofit retrofit;
    private static OkHttpClient okHttpClient;
    public ApiService apiService;

    private RetrofitClient() {
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(new DataEncryptInterceptor())
//                .addInterceptor(new NetWorkDetectedInterceptor(HttplibConfig.getContext()))    //网络拦截器，如果没网抛出异常
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .build();
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .build();

        apiService = create(ApiService.class);
    }

    public <T> T create(final Class<T> service) {
        if (service == null) {

        }
        return retrofit.create(service);
    }

    private static class SingletonHolder {
        private static RetrofitClient INSTANCE = new RetrofitClient();
    }


    public static RetrofitClient get() {
        return SingletonHolder.INSTANCE;
    }


}
