package com.dolphkon.httplib.utils;

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.httplib.utils
 * ClassName：
 * Author: kongdexi
 * Date: 2020/10/14 17:07
 * Description:TODO
 * *****************************************************
 */
public interface ProgressListener {
    void showProgress(String msg);


    void dismissProgress();
}
