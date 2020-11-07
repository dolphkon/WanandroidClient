package com.dolphkon.httplib.utils;

import com.dolphkon.httplib.base.BaseResponse;
import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.httplib.utils
 * ClassName：
 * Author: kongdexi
 * Date: 2020/10/14 16:39
 * Description:TODO
 * *****************************************************
 */
public class GsonUtil {
    /**
     * 把json解析成T类型
     *
     * @param json 需要解析的json
     * @return 返回结果
     */
    public static <T> T get(String json, Class<T> clazz) {
        try {
            Gson gson = new Gson();
            return gson.fromJson(json, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 把json解析成T类型
     *
     * @param json 需要解析的json
     * @return 返回结果
     */
    public static <T> T get(String json, Type type) {
        try {
            Gson gson = new Gson();
            return gson.fromJson(json, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getStr(BaseResponse response){
        try {
            Gson gson = new Gson();
            return gson.toJson(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}
