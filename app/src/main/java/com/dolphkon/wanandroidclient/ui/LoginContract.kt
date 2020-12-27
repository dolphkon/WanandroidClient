package com.dolphkon.wanandroidclient.ui

import com.dolphkon.httplib.base.BaseView
import com.dolphkon.httplib.base.IPresenter

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.wanandroidclient.ui
 * ClassName：
 * Author: kongdexi
 * Date: 2020/10/29 11:52
 * Description:TODO
 * *****************************************************
 */
interface LoginContract {
    interface View : BaseView<Any?> {
        fun updateRegisterView()
    }

    interface Presenter : IPresenter<View?> {
        fun register(account: String?, password: String?, repassword: String?)
    }
}