package com.dolphkon.wanandroidclient.ui;

import com.dolphkon.httplib.base.BaseView;
import com.dolphkon.httplib.base.IPresenter;

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.wanandroidclient.ui
 * ClassName：
 * Author: kongdexi
 * Date: 2020/10/29 11:52
 * Description:TODO
 * *****************************************************
 */
public interface LoginContract {
   interface View extends BaseView{
    void  updateRegisterView();
   }

    interface Presenter extends IPresenter<View> {
        void  register(String account,String password,String repassword);
    }

}
