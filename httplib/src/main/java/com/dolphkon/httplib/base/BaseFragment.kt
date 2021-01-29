package com.dolphkon.httplib.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dolphkon.httplib.utils.LoadingDialog
import com.dolphkon.httplib.utils.toast
import com.trello.rxlifecycle3.components.RxFragment

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.httplib.base
 * ClassName：BaseFragment
 * Author: kongdexi
 * Date: 2020/10/12 20:38
 * Description:TODO
 * *****************************************************
 */
abstract class BaseFragment : RxFragment() {
    protected abstract fun initView()
    protected abstract fun initData()
    protected abstract val resourceId: Int
    var mView: View? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mView = inflater.inflate(resourceId, null)
        initView()
        return mView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initData()
    }


    /**
     * 加载对话框
     */
    var dialog: LoadingDialog? = null
    fun showProgressDialog() {
        showProgressDialog("")
    }

    protected fun showProgressDialog(msgId: Int) {
        showProgressDialog(getString(msgId))
    }

    private fun showProgressDialog(msg: String?) {
        if (activity == null || activity.isFinishing) {
            return
        }
        if (dialog == null) {
            dialog = LoadingDialog(activity)
            dialog!!.setCancelable(false)
            dialog!!.setCanceledOnTouchOutside(false)
        }
        dialog?.show()
        if (msg != null) dialog?.setMessage(msg)
    }

    fun dismissProgressDialog() {
        if (dialog?.isShowing!!){
            dialog?.dismiss()
        }


    }
}