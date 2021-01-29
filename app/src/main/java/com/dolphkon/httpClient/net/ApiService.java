package com.dolphkon.httpClient.net;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

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
public interface ApiService {
    /**
     * 首页Banner
     * */
    @GET("banner/json")
    Observable<ResponseBody> queryBanners();

    /**
     *  注册
     * */
    @FormUrlEncoded
    @POST("user/register")
    Observable<ResponseBody> register(@Field("username") String username,@Field("password")String password,@Field("repassword")String repassword);

    /**
     *  登录
     * */
    @FormUrlEncoded
    @POST("user/login")
    Observable<ResponseBody>login(@Field("username") String username,@Field("password")String password);

}
