package com.dolphkon.httplib.base;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.dolphkon.httplib.progress.ProgressImpl;
import com.dolphkon.httplib.utils.LogUtil;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.httplib.base
 * ClassName：ShowLoadingTramsformer
 * Author: kongdexi
 * Date: 2020/11/3 17:05
 * Description:TODO
 * *****************************************************
 */
public class ShowLoadingTramsformer<T> implements ObservableTransformer<T, T> {

    private  ProgressImpl progressListener;
    private String message;
        private Context context;
       public ShowLoadingTramsformer(Context context) {
        this.context=context;
        this.progressListener = new ProgressImpl(context);
    }

    public ShowLoadingTramsformer(Context context,String msg){
        this.context=context;
        this.message=msg;
        this.progressListener = new ProgressImpl(context);
    }

    @Override
    public ObservableSource apply(Observable upstream) {
        return upstream.doOnSubscribe(new Consumer<Disposable>() {
            @Override
            public void accept(Disposable disposable) throws Exception {
                LogUtil.d("thread:"+Thread.currentThread().getName());
               showProgressDialog(message);
            }
        }).doFinally(new Action() {
            @Override
            public void run() throws Exception {
                if (progressListener!=null){
                    progressListener.dismissProgress();
                }
            }
        });
    }

    private void showProgressDialog(String message){
     if (progressListener==null){
         return;
     }

     if (TextUtils.isEmpty(message)){
         progressListener.showProgress("");
         return;
     }
     progressListener.showProgress(message);
    }

}
