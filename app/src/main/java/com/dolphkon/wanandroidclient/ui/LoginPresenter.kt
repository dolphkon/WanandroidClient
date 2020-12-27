package com.dolphkon.wanandroidclient.ui

import android.content.Context
import com.dolphkon.httplib.base.BasePresenter
import com.dolphkon.httplib.base.ShowLoadingTramsformer
import com.dolphkon.httplib.consumer.CommonObserver
import com.dolphkon.httplib.utils.LogUtil
import com.dolphkon.httplib.utils.RxHelper
import com.dolphkon.httplib.utils.ToastUtils
import com.dolphkon.wanandroidclient.bean.RegisterResp
import com.dolphkon.wanandroidclient.net.RetrofitClient
import com.dolphkon.wanandroidclient.ui.LoginContract.Presenter

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
class LoginPresenter(private val context: Context, private val view: LoginContract.View) : BasePresenter<LoginContract.View?>(), Presenter {

    /**
     * 注册
     */
    override fun register(account: String?, password: String?, repassword: String?) {
//        RetrofitClient.get().apiService
//                .register(account, password, repassword)
//                .compose(RxHelper.observableIO2Main(context))
//                .compose(ShowLoadingTramsformer<Any?>((view as Context)))
//                .subscribe(object : CommonObserver<RegisterResp?>() {
//                    override fun onSuccess(data: RegisterResp?) {
//                        LogUtil.d("response:" + data?.data)
//                    }
//
//                    override fun onError(msg: String, code: String) {
//                        ToastUtils.showToast(msg)
//                    }
//                })
    }

}