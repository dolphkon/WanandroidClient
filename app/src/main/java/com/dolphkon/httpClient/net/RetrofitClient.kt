package com.dolphkon.httpClient.net

import com.dolphkon.httpClient.net.Constant.BASE_URL
import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.httpClient.net
 * ClassName：RetrofitClient
 * Author: kongdexi
 * Date: 2020/10/30 9:28
 * Description:TODO
 * *****************************************************
 */
class RetrofitClient private constructor() {
    private val retrofit: Retrofit
    var apiService: ApiService
    fun <T> create(service: Class<T>?): T {
        if (service == null) {
        }
        return retrofit.create(service)
    }

    private object SingletonHolder {
        val INSTANCE = RetrofitClient()
    }

    companion object {
        private const val DEFAULT_TIMEOUT = 60
        private lateinit var okHttpClient: OkHttpClient
        fun get(): RetrofitClient {
            return SingletonHolder.INSTANCE
        }
    }

    init {
        okHttpClient = OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
                .addInterceptor(DataEncryptInterceptor())
                .writeTimeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
                .build()
        retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .build()
        apiService = create(ApiService::class.java)
    }

}