package com.dolphkon.httplib.base;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**********************************
 * Project：WanandroidClient
 * PackageName： com.dolphkon.httplib.base
 * ClassName： CommonObservableTransformer
 * Author： dolphkon
 * Date：2021/3/3 17:55
 * Description： TODO
 ************************************/
public class CommonObservableTransformer {

    public static ObservableTransformer getTransformer(){
        return upstream -> upstream.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
