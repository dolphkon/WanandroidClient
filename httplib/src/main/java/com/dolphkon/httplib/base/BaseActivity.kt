package com.dolphkon.httplib.base
import android.os.Bundle
import android.view.Window
import com.dolphkon.httplib.R
import com.dolphkon.httplib.utils.LoadingDialog

import com.dolphkon.httplib.utils.ToastUtils
import com.gyf.barlibrary.ImmersionBar
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity


abstract class BaseActivity : RxAppCompatActivity() {

    lateinit var dialog: LoadingDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        ImmersionBar.with(this)
                .statusBarDarkFont(true, 0.2f)
                .statusBarColor(R.color.transparent)
                .init()
        actionBar?.hide()
        setContentView(getResourceId())
        initView()
        initData()
    }


    abstract fun getResourceId(): Int
    abstract fun initView()
    abstract fun initData()

    protected open fun toast(strId: Int) {
        ToastUtils.showToast(strId)
    }


    protected open fun toast(strId: String?) {
        ToastUtils.showToast(strId)
    }


    fun showProgressDialog() {
        showProgressDialog("");
    }

    protected fun showProgressDialog(msg: String?) {
        if (dialog == null) {
            dialog = LoadingDialog(this);
            dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(false);
        }
        dialog.show()
        if (msg != null) dialog.setMessage(msg)
    }


    protected fun showProgressDialog(msgId: Int) {
        showProgressDialog(getString(msgId))
    }

    /**
     *  隐藏加载对话框
     * */
    fun dismissProgressDialog() {
        if (dialog?.isShowing) {
            dialog.dismiss()
        }
    }
}