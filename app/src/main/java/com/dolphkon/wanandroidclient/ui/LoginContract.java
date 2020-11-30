package com.dolphkon.wanandroidclient.ui;

import com.dolphkon.httplib.base.BaseView;
import com.dolphkon.httplib.base.IPresenter;
import com.dolphkon.wanandroidclient.bean.RegisterResp;

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
    void  updateRegisterView(RegisterResp registerResp);
   }

    interface Presenter extends IPresenter<View> {
        void  register(String account,String password,String repassword);
    }

}
