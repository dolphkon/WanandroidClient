package com.dolphkon.httpClient.ui

import android.content.Context
import com.dolphkon.httplib.base.BasePresenter
import com.dolphkon.httplib.base.ShowLoadingTramsformer
import com.dolphkon.httplib.consumer.CommonObserver
import com.dolphkon.httplib.utils.RxHelper
import com.dolphkon.httpClient.bean.RegisterResp
import com.dolphkon.httpClient.net.RetrofitClient
import com.dolphkon.httpClient.ui.LoginContract.Presenter
import com.dolphkon.httplib.utils.LogUtil
import com.dolphkon.httplib.utils.toast

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.httpClient.ui
 * ClassName：LoginPresenter
 * Author: kongdexi
 * Date: 2020/10/29 11:52
 * Description:TODO
 * *****************************************************
 */
class LoginPresenter(private val context: Context, private val view: LoginContract.View) : BasePresenter<LoginContract.View?>(), Presenter {

    /**
     * 注册
     */
    override fun register(account: String?, password: String?, repassword: String?) {
        RetrofitClient.get().apiService
                .register(account, password, repassword)
                .compose(RxHelper.observableIO2Main(context))
                .compose(ShowLoadingTramsformer(view as Context))
                .subscribe(
                        object : CommonObserver<RegisterResp>() {
                            override fun onSuccess(data: RegisterResp?) {
                                "注册成功".toast(context)
                                  view.updateRegisterView(data?.data)
                            }

                            override fun onError(msg: String?, code: String?) {
                                msg?.toast(context)
                            }

                        }
                )

    }

    override fun login(account: String?, password: String?) {
        RetrofitClient.get().apiService
                .login(account,password)
                .compose(RxHelper.observableIO2Main(context))
                .compose(ShowLoadingTramsformer(view as Context))
                .subscribe(
                        object : CommonObserver<RegisterResp>() {
                            override fun onSuccess(data: RegisterResp?) {
                            view.login()
                            }

                            override fun onError(msg: String?, code: String?) {
                              msg?.toast(context)
                            }

                        }
                )
    }

}