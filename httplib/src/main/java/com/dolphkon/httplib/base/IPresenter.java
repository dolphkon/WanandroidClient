package com.dolphkon.httplib.base;

import com.dolphkon.httplib.BaseView;

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.httplib.base
 * ClassName：
 * Author: kongdexi
 * Date: 2020/11/2 17:08
 * Description:TODO
 * *****************************************************
 */
public interface IPresenter<V extends BaseView>{
     void attachView(V mRootView);
     void detachView();

}
