package com.dolphkon.httplib.base

import android.content.Context
import android.text.TextUtils
import com.dolphkon.httplib.progress.ProgressImpl
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.httplib.base
 * ClassName：ShowLoadingTramsformer
 * Author: kongdexi
 * Date: 2020/11/3 17:05
 * Description:TODO
 * *****************************************************
 */
class ShowLoadingTramsformer<T> : ObservableTransformer<T, T> {
    private var progressListener: ProgressImpl?
    private var message: String? = null
    private var context: Context

    constructor(context: Context) {
        this.context = context
        progressListener = ProgressImpl(context)
    }

    constructor(context: Context, msg: String?) {
        this.context = context
        message = msg
        progressListener = ProgressImpl(context)
    }

    override fun apply(upstream: Observable<T>): ObservableSource<T> {
        return upstream.doOnSubscribe { showProgressDialog(message) }.doFinally {
            if (progressListener != null) {
                progressListener!!.dismissProgress()
            }
        }
    }

    private fun showProgressDialog(message: String?) {
        if (progressListener == null) {
            return
        }
        if (TextUtils.isEmpty(message)) {
            progressListener!!.showProgress("")
            return
        }
        progressListener!!.showProgress(message)
    }

}