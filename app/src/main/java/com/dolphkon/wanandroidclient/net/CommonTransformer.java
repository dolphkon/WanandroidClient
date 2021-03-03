package com.dolphkon.wanandroidclient.net;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/*****************************
 * 项目名：android
 * 包名： com.jlpay.merch.net
 * 文件名： CommonObservable
 * 创建者： kongdexi
 * 创建时间：2021/2/25 13:57
 * 描述： TODO
 * **************************/
public class CommonTransformer {
    /**
     * 线程切换
     * @return
     */
    public static ObservableTransformer getTransformer() {
        return new ObservableTransformer() {
            @Override
            public ObservableSource apply(Observable upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}