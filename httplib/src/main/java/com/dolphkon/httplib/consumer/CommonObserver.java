package com.dolphkon.httplib.consumer;

import com.dolphkon.httplib.base.BaseResponse;
import com.dolphkon.httplib.callback.NetCallBack;
import com.dolphkon.httplib.error.ExceptionHandle;
import com.dolphkon.httplib.error.RxException;
import com.dolphkon.httplib.utils.GsonUtil;
import com.dolphkon.httplib.utils.HttplibManager;

import org.json.JSONObject;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;

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
public abstract class CommonObserver<T> implements Observer<ResponseBody>, NetCallBack<T> {
    @Override
    public void onSubscribe(Disposable d){
        if (!HttplibManager.isNetworkAvailable(HttplibManager.getContext())) {
            RxException ex = new RxException(ExceptionHandle.ERROR.NETWORD_ERROR);
            ex.message = "网络不可用,请检查网络设置是否正常";
            onError(ex);
            onComplete();
            if (!d.isDisposed()){
                 d.dispose();
            }
        }
    }

    @Override
    public void onNext(ResponseBody responseBody) {
        String response = null;
        try {
            response = responseBody.string();
            JSONObject obj = new JSONObject(response);
            Type type = getType();
            T bean = GsonUtil.get(obj.toString(), type);
            if (bean instanceof BaseResponse) {
                if (((BaseResponse) bean).isOk()) {
                    onSuccess(bean);
                } else {
                    onError(((BaseResponse) bean).getRet_msg(), ((BaseResponse) bean).getRet_code());
                }
            } else {
                onSuccess(bean);
            }
            onComplete();
        } catch (Exception e) {
            e.printStackTrace();
            onError(e);
        } finally {
            responseBody.close();
        }
    }


    @Override
    public void onError(Throwable e) {
        if (e instanceof RxException) {
            onError((RxException) e);
        } else {
            onError(ExceptionHandle.handleException(e));
        }
    }

    @Override
    public void onComplete() {

    }

    /**
     * 错误回调
     *
     * @param e
     */
    public void onError(RxException e) {
        if (e != null) {
            onError(e.message, e.errorCode);
        } else {
            onError("未知错误", ExceptionHandle.ERROR.UNKNOWN + "");
        }

    }

    /**
     * 获得带有泛型的父类
     *
     * @return
     */
    private Type getType() {
        Type superclass = getClass().getGenericSuperclass();
        if (superclass instanceof Class) {
            throw new RuntimeException("须传入指定类型");
        }
        ParameterizedType parameterized = (ParameterizedType) superclass;
        Type type = parameterized.getActualTypeArguments()[0];
        return type;
    }

}
