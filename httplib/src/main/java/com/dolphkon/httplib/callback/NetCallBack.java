package com.dolphkon.httplib.callback;

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.httplib.base
 * ClassName：NetCallBack
 * Author: kongdexi
 * Date: 2020/11/7 15:30
 * Description:网络结果的回调
 * *****************************************************
 */
public interface NetCallBack<T> {
    /**
     * 成功回调
     *
     * @param data
     */
    void onSuccess(T data);


    /**
     * 失败回调
     *
     * @param msg
     * @param code
     */
    void onError(String msg, String code);
}
