package com.dolphkon.wanandroidclient.ui;
import android.content.Context;
import com.dolphkon.httplib.base.BaseDisposable;
import com.dolphkon.httplib.base.CommonObservableTransformer;
import com.dolphkon.httplib.consumer.CommonObserver;
import com.dolphkon.httplib.base.ShowLoadingTramsformer;
import com.dolphkon.httplib.utils.ToastUtils;
import com.dolphkon.wanandroidclient.bean.RegisterResp;
import com.dolphkon.wanandroidclient.net.RetrofitClient;

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
public class LoginPresenter extends BaseDisposable implements LoginContract.Presenter {
    private LoginContract.View mView;
    private Context context;
    public LoginPresenter(Context context, LoginContract.View view) {
        this.context = context;
        this.mView = view;
    }
    /**
     * 注册
     */
    @Override
    public void register(String account, String password, String repassword) {
        RetrofitClient.get()
                .apiService
                .register(account, password, repassword)
                .doOnSubscribe(disposable -> addDisposable(disposable))
                .compose(new ShowLoadingTramsformer((Context) mView))
                .compose(CommonObservableTransformer.getTransformer())
                .subscribe(new CommonObserver<RegisterResp>() {
                    @Override
                    public void onSuccess(RegisterResp data) {
                        mView.hideLoading();
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
        mView.showLoading();
        RetrofitClient.get()
                .apiService
                .login(account, password)
                .compose(CommonObservableTransformer.getTransformer())
                .subscribe(new CommonObserver<RegisterResp>() {
                    @Override
                    public void onSuccess(RegisterResp data) {
                        mView.hideLoading();
                        mView.login(data);
                    }

                    @Override
                    public void onError(String msg, String code) {
                        mView.hideLoading();
                        ToastUtils.showToast(msg);
                    }
                });
    }

}
