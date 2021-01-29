package com.dolphkon.httplib.consumer

import com.dolphkon.httplib.base.BaseResponse
import com.dolphkon.httplib.callback.NetCallBack
import com.dolphkon.httplib.error.ErrorCode
import com.dolphkon.httplib.error.ExceptionHandle
import com.dolphkon.httplib.error.RxException
import com.dolphkon.httplib.utils.GsonUtil
import com.dolphkon.httplib.utils.HttplibManager
import com.dolphkon.httplib.utils.LogUtil
import com.google.gson.Gson
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import okhttp3.ResponseBody
import org.json.JSONException
import org.json.JSONObject
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.httplib.base
 * ClassName：BaseObserver
 * Author: kongdexi
 * Date: 2020/10/14 15:21
 * Description:原始的网络请求数据解析
 * *****************************************************
 */
abstract class CommonObserver<T> : Observer<ResponseBody>, NetCallBack<T> {
    override fun onSubscribe(d: Disposable) {
        if (!HttplibManager.isNetworkAvailable(HttplibManager.getContext())) {
            val ex = RxException(ErrorCode.NETWORD_ERROR)
            ex.message = "网络不可用,请检查网络设置是否正常"
            onError(ex)
            onComplete()
            if (!d.isDisposed) {
                d.dispose()
            }
        }
    }

    override fun onNext(responseBody: ResponseBody) {
        var response: String? = null
        try {
            response = responseBody.string()
            val result: BaseResponse = GsonUtil.get(response, BaseResponse::class.java) ?: throw JSONException("解析异常")
           if (result.isOk){
               val type = type
               val data: T = Gson().fromJson(response, type) ?: throw RuntimeException("数据解析异常")
              onSuccess(data)
           }else{
               onError(result.errorMsg, result.errorCode)
           }
            onComplete()
        } catch (e: Exception) {
            e.printStackTrace()
            onError(e)
        } finally {
            responseBody.close()
        }
    }

    override fun onError(e: Throwable) {
        if (e is RxException) {
            onError(e.message, e.errorCode + "")
        } else {
            onError(ExceptionHandle.handleException(e).message,ExceptionHandle.handleException(e).errorCode+"")
        }
    }

    override fun onComplete() {}

    /**
     * 获得带有泛型的父类
     *
     * @return
     */
    private val type: Type
        private get() {
            val superclass = javaClass.genericSuperclass
            if (superclass is Class<*>) {
                throw RuntimeException("须传入指定类型")
            }
            val parameterized = superclass as ParameterizedType?
            return parameterized!!.actualTypeArguments[0]
        }
}