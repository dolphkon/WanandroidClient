package com.dolphkon.httplib.utils;

import android.os.Handler;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.httplib.utils
 * ClassName：ToastUtils
 * Author: kongdexi
 * Date: 2020/10/12 17:21
 * Description:TODO
 * *****************************************************
 */
public class ToastUtils {
    private static final int SHOW_INTERVEL = 3000;
    public static Toast toast;
    public static Handler handler = new Handler();
    public static Runnable runnable = new Runnable() {

        @Override
        public void run() {
            if (toast != null) {
                toast.cancel();
            }
        }
    };

    public static void showToast(String msg) {
        showToastApplication(msg);
    }

    /**
     * @param str
     */
    public static void showToastApplication(String str) {

        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            handler.removeCallbacks(runnable);
            if (toast == null) {
                toast = Toast.makeText(HttplibConfig.getContext(), str, Toast.LENGTH_LONG);
                toast.setText(str);
            } else {
                toast.setText(str);
            }
            toast.show();
            handler.postDelayed(runnable, SHOW_INTERVEL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showToast(int strId) {
        showToast(HttplibConfig.getContext().getString(strId));
    }
}
