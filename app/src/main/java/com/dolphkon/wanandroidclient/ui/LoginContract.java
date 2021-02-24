package com.dolphkon.wanandroidclient.ui;

import com.dolphkon.httplib.base.BaseView;
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
    void  login(RegisterResp registerResp);
   }

    interface Presenter {
        void  register(String account,String password,String repassword);
        void  login(String account,String password);
    }

}
