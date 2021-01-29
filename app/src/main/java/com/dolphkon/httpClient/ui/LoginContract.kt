package com.dolphkon.httpClient.ui

import com.dolphkon.httpClient.bean.RegisterResp.DataBean
import com.dolphkon.httplib.base.BaseView
import com.dolphkon.httplib.base.IPresenter

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.httpClient.ui
 * ClassName：
 * Author: kongdexi
 * Date: 2020/10/29 11:52
 * Description:TODO
 * *****************************************************
 */
interface LoginContract {
    interface View : BaseView<Any?> {
        fun updateRegisterView( data: DataBean?)
        fun login()
    }

    interface Presenter : IPresenter<View?> {
        fun register(account: String?, password: String?, repassword: String?)

        fun login(account: String?,password: String?)
    }
}