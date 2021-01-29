package com.dolphkon.httplib.utils

import android.content.Context
import com.trello.rxlifecycle3.android.ActivityEvent
import com.trello.rxlifecycle3.components.RxActivity
import com.trello.rxlifecycle3.components.RxFragment
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity
import com.trello.rxlifecycle3.components.support.RxFragmentActivity
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.httplib.base
 * ClassName：RxHelper
 * Author: kongdexi
 * Date: 2020/11/2 14:25
 * Description:线程切换及绑定生命周期
 * *****************************************************
 */
object RxHelper {
    fun <T> observableIO2Main(context: Context): ObservableTransformer<T, T> {
        return ObservableTransformer { upstream: Observable<T> ->
            val observable = upstream.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
            composeContext(context, observable)
        }
    }

    fun <T> observableIO2Main(fragment: RxFragment): ObservableTransformer<T, T> {
        return ObservableTransformer { upstream: Observable<T> ->
            upstream.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread()).compose(fragment.bindToLifecycle())
        }
    }

    fun <T> flowableIO2Main(): FlowableTransformer<T, T> {
        return FlowableTransformer { upstream: Flowable<T> ->
            upstream
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
        }
    }

    private fun <T> composeContext(context: Context, observable: Observable<T>): ObservableSource<T> {
        return when (context) {
            is RxActivity -> {
                observable.compose(context.bindUntilEvent(ActivityEvent.DESTROY))
            }
            is RxFragmentActivity -> {
                observable.compose(context.bindUntilEvent(ActivityEvent.DESTROY))
            }
            is RxAppCompatActivity -> {
                observable.compose(context.bindUntilEvent(ActivityEvent.DESTROY))
            }
            else -> {
                observable
            }
        }
    }
}