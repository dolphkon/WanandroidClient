package com.dolphkon.httplib.utils

import com.dolphkon.httplib.base.BaseResponse
import com.google.gson.Gson
import java.lang.reflect.Type

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
object GsonUtil {
    /**
     * 把json解析成T类型
     *
     * @param json 需要解析的json
     * @return 返回结果
     */
    operator fun <T> get(json: String?, clazz: Class<T>?): T? {
        try {
            val gson = Gson()
            return gson.fromJson(json, clazz)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    /**
     * 把json解析成T类型
     *
     * @param json 需要解析的json
     * @return 返回结果
     */
    operator fun <T> get(json: String?, type: Type?): T? {
        try {
            val gson = Gson()
            return gson.fromJson(json, type)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    fun getStr(response: BaseResponse?): String {
        try {
            val gson = Gson()
            return gson.toJson(response)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return ""
    }
}