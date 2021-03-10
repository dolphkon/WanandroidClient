package com.jlpay.merch.ui.base

import com.dolphkon.httplib.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**********************************
 * Project：android
 * PackageName： com.jlpay.merch.ui.base
 * ClassName： CommonDisposable
 * Author： dolphkon
 * Date：2021/3/3 19:48
 * Description： TODO
 */
abstract class CommonDisposable : BasePresenter {
    private var mCompositeDisposable: CompositeDisposable? = null
    override fun addDisposable(disposable: Disposable?) {
        if (mCompositeDisposable == null || mCompositeDisposable!!.isDisposed) {
            mCompositeDisposable = CompositeDisposable()
        }
        mCompositeDisposable?.add(disposable!!)
    }

    /**
     * 在界面退出等需要解绑观察者的情况下调用此方法统一解绑，防止Rx造成的内存泄漏
     */
    override fun unDisposable() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable?.dispose()
        }
    }
}