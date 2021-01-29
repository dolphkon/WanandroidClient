package com.dolphkon.httplib.progress

import android.content.Context
import android.text.TextUtils
import com.dolphkon.httplib.callback.ProgressListener
import com.dolphkon.httplib.utils.LoadingDialog

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.httplib.progress
 * ClassName：ProgressImpl
 * Author: kongdexi
 * Date: 2020/10/14 17:08
 * Description:TODO
 * *****************************************************
 */
class ProgressImpl(private val mContext: Context) : ProgressListener {
    override fun showProgress(msg: String?) {
        if (TextUtils.isEmpty(msg)) {
            showProgressDialog("")
            return
        }
        showProgressDialog(msg)
    }

    override fun dismissProgress() {
        dismissProgressDialog()
    }

    var dialog: LoadingDialog? = null
    protected fun showProgressDialog(msg: String?) {
        if (dialog == null) {
            dialog = LoadingDialog(mContext)
            dialog!!.setCancelable(false)
            dialog!!.setCanceledOnTouchOutside(false)
        }
        dialog!!.show()
        if (msg != null) {
            dialog!!.setMessage(msg)
        }
    }

    private fun dismissProgressDialog() {
        if (dialog != null && dialog!!.isShowing) {
            dialog!!.dismiss()
            dialog = null
        }
    }

}