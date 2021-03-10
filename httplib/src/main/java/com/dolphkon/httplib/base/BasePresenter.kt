package com.dolphkon.httplib.base

import io.reactivex.disposables.Disposable


interface BasePresenter {
    fun addDisposable(subscription: Disposable?)
    fun unDisposable()
}
