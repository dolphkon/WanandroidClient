package com.dolphkon.httplib.base;

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.httplib.base
 * ClassName：
 * Author: kongdexi
 * Date: 2020/10/12 15:16
 * Description:TODO
 * *****************************************************
 */

public  class BasePresenter<V extends BaseView>{
    private V mRootView;
    public void attachView(V mRootView){
             this.mRootView=mRootView;
    }
    public void detachView(){
            mRootView = null;
    }
}
