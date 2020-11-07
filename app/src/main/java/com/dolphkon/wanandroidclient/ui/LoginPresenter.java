package com.dolphkon.wanandroidclient.ui;

import android.content.Context;

import com.dolphkon.httplib.base.BasePresenter;
import com.dolphkon.httplib.base.CommonObserver;
import com.dolphkon.httplib.base.ParseDateFromServerTransformer;
import com.dolphkon.httplib.base.RxHelper;
import com.dolphkon.httplib.base.ShowLoadingTramsformer;
import com.dolphkon.httplib.utils.LogUtil;
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
public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {
    private LoginContract.View view;
    private Context context;

    public LoginPresenter(Context context, LoginContract.View view) {
        this.context = context;
        this.view = view;
    }

    /**
     * 注册
     */
    @Override
    public void register(String account, String password, String repassword) {
        RetrofitClient.get()
                .apiService
                .register(account, password, repassword)
                .compose(new ParseDateFromServerTransformer<RegisterResp>() {
                })
                .compose(RxHelper.observableIO2Main(context))
                .compose(new ShowLoadingTramsformer<RegisterResp>( context))
                .subscribe(new CommonObserver<RegisterResp>() {
                    @Override
                    public void onSuccess(RegisterResp data) {
                        LogUtil.d("data:"+data.data);
                    }

                    @Override
                    public void onError(String msg, String code) {
                        ToastUtils.showToast(msg);
                    }

                });
    }
}
