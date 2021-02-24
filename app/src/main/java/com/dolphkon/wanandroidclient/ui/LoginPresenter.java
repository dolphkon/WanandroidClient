package com.dolphkon.wanandroidclient.ui;
import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.dolphkon.httplib.consumer.CommonObserver;
import com.dolphkon.httplib.utils.RxHelper;
import com.dolphkon.httplib.base.ShowLoadingTramsformer;
import com.dolphkon.httplib.utils.ToastUtils;
import com.dolphkon.wanandroidclient.bean.RegisterResp;
import com.dolphkon.wanandroidclient.net.RetrofitClient;
import com.trello.lifecycle2.android.lifecycle.AndroidLifecycle;
import com.trello.rxlifecycle3.LifecycleProvider;
import java.util.concurrent.TimeUnit;

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.wanandroidclient.ui
 * ClassName：LoginPresenter
 * Author: kongdexi
 * Date: 2020/10/29 11:52
 * Description:TODO
 * *****************************************************
 */
public class LoginPresenter  implements LoginContract.Presenter {
    private final LifecycleProvider<Lifecycle.Event> mLifecycleProvider;
    private LoginContract.View mView;
    private Context context;

    public LoginPresenter(Context context, LoginContract.View view) {
        this.context = context;
        this.mView = view;
        mLifecycleProvider = AndroidLifecycle.createLifecycleProvider((LifecycleOwner) mView);
    }

    /**
     * 注册
     */
    @Override
    public void register(String account, String password, String repassword) {
        RetrofitClient.get()
                .apiService
                .register(account, password, repassword)
                .delay(5, TimeUnit.SECONDS)
                .compose(RxHelper.observableIO2Main(context))
                .compose(new ShowLoadingTramsformer((Context) mView))
                .compose(mLifecycleProvider.<Long>bindUntilEvent(Lifecycle.Event.ON_DESTROY))
                .subscribe(new CommonObserver<RegisterResp>() {
                    @Override
                    public void onSuccess(RegisterResp data) {
                        mView.updateRegisterView(data);
                    }

                    @Override
                    public void onError(String msg, String code) {
                        ToastUtils.showToast(msg);
                    }
                });
    }


    /**
     *  登陆
     * */
    @Override
    public void login(String account, String password) {
        RetrofitClient.get()
                .apiService
                .login(account, password)
                .compose(RxHelper.observableIO2Main(context))
                .compose(new ShowLoadingTramsformer((Context) mView))
                .compose(mLifecycleProvider.<Long>bindUntilEvent(Lifecycle.Event.ON_DESTROY))
                .subscribe(new CommonObserver<RegisterResp>() {
                    @Override
                    public void onSuccess(RegisterResp data) {
                        mView.login(data);
                    }

                    @Override
                    public void onError(String msg, String code) {
                        ToastUtils.showToast(msg);
                    }
                });


    }

}
