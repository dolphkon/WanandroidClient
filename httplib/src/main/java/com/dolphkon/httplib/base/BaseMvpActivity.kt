package com.dolphkon.httplib.base

import android.os.Bundle

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.httplib.base
 * ClassName：BaseMvpActivity
 * Author: kongdexi
 * Date: 2020/10/12 20:23
 * Description:TODO
 * *****************************************************
 */
abstract class BaseMvpActivity<P : BasePresenter> : BaseActivity(), BaseView {
    @JvmField
    var mPresenter: P? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        if (mPresenter == null) {
            mPresenter = createPresenter()
        }
        if (mPresenter == null) {
            throw NullPointerException("mPresenter 不能为空!")
        }
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        mPresenter?.unDisposable()
        mPresenter = null
        super.onDestroy()
    }

    protected abstract fun createPresenter(): P

    override fun showLoading() {
        showProgressDialog()
    }

    override fun showLoading(msg: String?) {
        showProgressDialog(msg)
    }

    override fun showLoading(msgid: Int) {
        showProgressDialog(msgid)
    }

    override fun hideLoading() {
        dismissProgressDialog()
    }
}