package com.dolphkon.httplib.base

interface BaseView<T> {
    fun showLoading()
    fun showLoading(msg: String?)
    fun showLoading(msgId: Int)
    fun hideLoading()
    fun showToast(msg: String?)
    fun showToast(msgId: Int)




}