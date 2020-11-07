package com.dolphkon.httplib.utils;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.dolphkon.httplib.R;

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.httplib.utils
 * ClassName：
 * Author: kongdexi
 * Date: 2020/10/12 17:28
 * Description:自定义Dialog网络加载等待弹窗（dialog）
 * *****************************************************
 */
public class LoadingDialog extends Dialog {

    TextView mTvMessage;

    public LoadingDialog(Context context) {
        super(context, R.style.ProgressDialog);
        init();

    }
    private void init() {
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        setContentView(R.layout.dialog_loading);
        mTvMessage = findViewById(R.id.tv_message);
    }

    public void setMessage(String msg) {
        if (!TextUtils.isEmpty(msg)) {
            mTvMessage.setVisibility(View.VISIBLE);
            mTvMessage.setText(msg);
        } else {
            mTvMessage.setVisibility(View.GONE);
        }

    }

}

