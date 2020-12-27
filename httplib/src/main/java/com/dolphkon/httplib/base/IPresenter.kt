package com.dolphkon.httplib.base

interface IPresenter<V : BaseView<*>?> {
    fun attachView(mRootView: V)
    fun detachView()

}