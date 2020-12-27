package com.dolphkon.wanandroidclient.ui

import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import butterknife.BindView
import butterknife.OnClick
import com.dolphkon.httplib.base.BaseMvpActivity
import com.dolphkon.httplib.utils.LoadingDialog
import com.dolphkon.httplib.utils.ToastUtils
import com.dolphkon.wanandroidclient.ClearEditText
import com.dolphkon.wanandroidclient.R
import com.dolphkon.wanandroidclient.ui.LoginContract.Presenter

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.wanandroidclient.ui
 * ClassName：LoginActivity
 * Author: kongdexi
 * Date: 2020/10/29 11:30
 * Description:TODO
 * *****************************************************
 */
class LoginActivity : BaseMvpActivity<LoginContract.View?, Presenter?>(), LoginContract.View {
    @BindView(R.id.edit_account)
    var editAccount: ClearEditText? = null

    @BindView(R.id.edit_password)
    var editPassword: ClearEditText? = null

    @BindView(R.id.btn_login)
    var btnLogin: Button? = null

    @BindView(R.id.tv_register)
    var tvRegister: TextView? = null

    @BindView(R.id.ll_repassword)
    var llRepassword: LinearLayout? = null

    @BindView(R.id.edit_repassword)
    var editRepassword: ClearEditText? = null
    private var isLogin = true
    private var account: String? = null
    private var password: String? = null
    private var rePassword: String? = null
    override fun initView() {}
    override fun initData() {}
    override fun getResourceId(): Int {
        return R.layout.activity_login
    }

    override fun createPresenter(): Presenter {
        return LoginPresenter(this, this)
    }

    @OnClick(R.id.btn_login, R.id.tv_register)
    fun onViewClick(view: View) {
        when (view.id) {
            R.id.btn_login -> if (!isLogin) {
                RegisterVerification()
                return
            }
            R.id.tv_register -> {
                llRepassword!!.visibility = View.VISIBLE
                isLogin = false
                btnLogin!!.text = "注册"
                tvRegister!!.visibility = View.GONE
            }
        }
    }

    private fun RegisterVerification() {
        account = editAccount!!.text.toString().trim { it <= ' ' }
        password = editPassword!!.text.toString().trim { it <= ' ' }
        rePassword = editRepassword!!.text.toString().trim { it <= ' ' }
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

    override fun updateRegisterView() {}
}