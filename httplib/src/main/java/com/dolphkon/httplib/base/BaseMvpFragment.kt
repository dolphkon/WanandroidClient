package com.dolphkon.httplib.base

import android.os.Bundle

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.httplib.base
 * ClassName：
 * Author: kongdexi
 * Date: 2020/10/12 20:39
 * Description:TODO
 * *****************************************************
 */
abstract class BaseMvpFragment<V : BaseView<*>?, P : IPresenter<V>?> : BaseFragment(), BaseView<P> {
    private var mPresenter: P? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (mPresenter == null) {
            mPresenter = createPresenter()
        }
        if (mPresenter == null) {
            throw NullPointerException("mPresenter 不能为空!")
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        mPresenter!!.detachView()
        mPresenter = null
    }

    protected abstract fun createPresenter(): P

    override fun showLoading() {
        showLoading()
    }

    override fun showLoading(msg: String?) {
        showLoading(msg)
    }

    override fun showLoading(msgId: Int) {
        showLoading(msgId)
    }

    override fun hideLoading() {
        dismissProgressDialog()
    }

    override fun initView() {}
    override fun initData() {}
}