package com.dolphkon.httplib.base

interface BaseView {
    fun showLoading()
    fun showLoading(msg: String?)
    fun showLoading(msgId: Int)
    fun hideLoading()




}