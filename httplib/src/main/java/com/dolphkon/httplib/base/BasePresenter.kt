package com.dolphkon.httplib.base

open class BasePresenter<V:BaseView<*>?> {
    private var mRootView: V? = null
    fun attachView(mRootView: V) {
        this.mRootView = mRootView
    }

    fun detachView() {
        mRootView = null
    }
}