package com.dolphkon.httpClient.net

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.httpClient.net
 * ClassName：ApiService
 * Author: kongdexi
 * Date: 2020/10/29 16:30
 * Description:TODO
 * *****************************************************
 */
interface ApiService {
    /**
     * 首页Banner
     */
    @GET("banner/json")
    fun queryBanners(): Observable<ResponseBody?>?

    /**
     * 注册
     */
    @FormUrlEncoded
    @POST("user/register")
    fun register(@Field("username") username: String?, @Field("password") password: String?, @Field("repassword") repassword: String?): Observable<ResponseBody>

    /**
     * 登录
     */
    @FormUrlEncoded
    @POST("user/login")
    fun login(@Field("username") username: String?, @Field("password") password: String?): Observable<ResponseBody>
}