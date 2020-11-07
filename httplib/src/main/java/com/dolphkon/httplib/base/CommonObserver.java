package com.dolphkon.httplib.base;
import com.dolphkon.httplib.error.ErrorCode;
import com.dolphkon.httplib.error.ExceptionHandle;
import com.dolphkon.httplib.error.RxException;


import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.httplib.base
 * ClassName：BaseObserver
 * Author: kongdexi
 * Date: 2020/10/14 15:21
 * Description:网络请求的
 * *****************************************************
 */
public abstract class CommonObserver<T> implements Observer<T>,NetCallBack<T> {


    @Override
    public void onSubscribe(Disposable d)  {
    }

    @Override
    public void onNext(T t) {
              onSuccess(t);
              onComplete();
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
            onError(e.message, e.errorCode + "");
        } else {
            onError("未知错误", ExceptionHandle.ERROR.UNKNOWN + "");
        }

    }

}
