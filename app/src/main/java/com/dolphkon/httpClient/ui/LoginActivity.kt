package com.dolphkon.httpClient.ui

import android.text.TextUtils
import android.view.View
import com.dolphkon.httpClient.R
import com.dolphkon.httpClient.bean.RegisterResp
import com.dolphkon.httpClient.ui.LoginContract.Presenter
import com.dolphkon.httplib.base.BaseMvpActivity
import com.dolphkon.httplib.utils.toast
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
                return@setOnClickListener
            }
            loginVerification()

        }
        tv_register.setOnClickListener{
            ll_repassword!!.visibility = View.VISIBLE
            isLogin = false
            btn_login?.text = "注册"
            tv_register?.visibility = View.GONE
        }


    }
    override fun initData() {}
    override fun getResourceId(): Int {
        return R.layout.activity_login
    }

    override fun createPresenter(): Presenter {
        return LoginPresenter(this, this)
    }


    private fun loginVerification(){
        account = edit_account?.text.toString().trim()
        password = edit_password?.text.toString().trim()
        if (TextUtils.isEmpty(account)) {
        "请输入用户名".toast(this)
            return
        }
        if (TextUtils.isEmpty(password)) {
          "请输入密码".toast(this)
            return
        }
        mPresenter?.login(account, password)
    }

    private fun RegisterVerification() {
        account = edit_account?.text.toString().trim()
        password = edit_password?.text.toString().trim()
        rePassword = edit_repassword?.text.toString().trim()
        if (TextUtils.isEmpty(account)) {
           "请输入用户名".toast(this)
            return
        }
        if (TextUtils.isEmpty(password)) {
            "请输入密码".toast(this)
            return
        }
        if (TextUtils.isEmpty(rePassword)) {
        getString(R.string.repassword).toast(this)
            return
        }
        mPresenter?.register(account, password, rePassword)
    }

    override fun updateRegisterView(data: RegisterResp.DataBean?) {
        if (data==null) return
        edit_account.setText("")
        edit_password.setText("")
        ll_repassword.visibility = View.GONE
        tv_register?.visibility = View.VISIBLE
        btn_login.setText("登陆")
    }

    override fun login() {
        "登陆成功".toast(this)
    }
}