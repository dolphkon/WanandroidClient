package com.dolphkon.httplib.utils

import android.app.Dialog
import android.content.Context
import android.text.TextUtils
import android.view.View
import android.widget.TextView
import com.dolphkon.httplib.R

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.httplib.utils
 * ClassName：LoadingDialog
 * Author: kongdexi
 * Date: 2020/10/12 17:28
 * Description:自定义Dialog网络加载等待弹窗（dialog）
 * *****************************************************
 */
class LoadingDialog(context: Context?) : Dialog(context!!, R.style.ProgressDialog) {
    var mTvMessage: TextView? = null
    private fun init() {
        setCancelable(true)
        setCanceledOnTouchOutside(false)
        setContentView(R.layout.dialog_loading)
        mTvMessage = findViewById(R.id.tv_message)
    }

    fun setMessage(msg: String?) {
        if (!TextUtils.isEmpty(msg)) {
            mTvMessage!!.visibility = View.VISIBLE
            mTvMessage!!.text = msg
        } else {
            mTvMessage!!.visibility = View.GONE
        }
    }

    init {
        init()
    }
}