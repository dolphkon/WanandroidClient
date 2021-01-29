package com.dolphkon.httpClient.ui

import android.text.TextUtils
import android.view.View
import com.dolphkon.httplib.base.BaseMvpActivity
import com.dolphkon.httplib.utils.ToastUtils
import com.dolphkon.httpClient.R
import com.dolphkon.httpClient.ui.LoginContract.Presenter
import kotlinx.android.synthetic.main.activity_login.*

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.httpClient.ui
 * ClassName：LoginActivity
 * Author: kongdexi
 * Date: 2020/10/29 11:30
 * Description:TODO
 * *****************************************************
 */
class LoginActivity : BaseMvpActivity<LoginContract.View?, Presenter?>(), LoginContract.View {
    private var isLogin = true
    private var account: String? = null
    private var password: String? = null
    private var rePassword: String? = null
    override fun initView() {
        btn_login.setOnClickListener {
            if (!isLogin) {
                RegisterVerification()
            }
        }
        tv_register.setOnClickListener{
            ll_repassword!!.visibility = View.VISIBLE
            isLogin = false
            btn_login!!.text = "注册"
            tv_register!!.visibility = View.GONE
        }


    }
    override fun initData() {}
    override fun getResourceId(): Int {
        return R.layout.activity_login
    }

    override fun createPresenter(): Presenter {
        return LoginPresenter(this, this)
    }


    private fun RegisterVerification() {
        account = edit_account!!.text.toString().trim()
        password = edit_account!!.text.toString().trim()
        rePassword = edit_account!!.text.toString().trim()
        if (TextUtils.isEmpty(account)) {
            ToastUtils.showToast("请输入用户名")
            return
        }
        if (TextUtils.isEmpty(password)) {
            ToastUtils.showToast("请输入密码")
            return
        }
        if (TextUtils.isEmpty(rePassword)) {
            ToastUtils.showToast("请再次输入密码")
            return
        }
        mPresenter!!.register(account, password, rePassword)
    }

    override fun updateRegisterView() {

    }
}