package com.dolphkon.httplib.progress;

import android.content.Context;
import android.text.TextUtils;

import com.dolphkon.httplib.utils.LoadingDialog;
import com.dolphkon.httplib.callback.ProgressListener;

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
public class ProgressImpl implements ProgressListener {

    private Context mContext;

    public ProgressImpl(Context context) {
        this.mContext = context;
    }


    @Override
    public void showProgress(String msg) {
    if (TextUtils.isEmpty(msg)){
        showProgressDialog("");
        return;
    }
        showProgressDialog(msg);
    }

    @Override
    public void dismissProgress() {
        dismissProgressDialog();
    }

    LoadingDialog dialog;

    protected void showProgressDialog(String msg) {
        if (dialog == null) {
            dialog = new LoadingDialog(mContext);
            dialog.setCancelable(false);
            dialog.setCanceledOnTouchOutside(false);
        }
        dialog.show();
        if (msg != null) {
            dialog.setMessage(msg);
        }

    }

    public void dismissProgressDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
            dialog=null;
        }

    }
}
