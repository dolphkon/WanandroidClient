package com.dolphkon.wanandroidclient.bean;

import com.dolphkon.httplib.base.BaseResponse;

import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.wanandroidclient.bean
 * ClassName：
 * Author: kongdexi
 * Date: 2020/11/3 11:26
 * Description:TODO
 * *****************************************************
 */
public class RegisterResp extends BaseResponse {
    public DataBean data;

    public RegisterResp(@Nullable String ret_code, @Nullable String ret_msg) {
        super(ret_code, ret_msg);
    }

    public class DataBean {
        /**
         * admin : false
         * chapterTops : []
         * coinCount : 0
         * collectIds : []
         * email :
         * icon :
         * id : 81035
         * nickname : hxjdjjd
         * password :
         * publicName : hxjdjjd
         * token :
         * type : 0
         * username : hxjdjjd
         */

        public boolean admin;
        public int coinCount;
        public String email;
        public String icon;
        public int id;
        public String nickname;
        public String password;
        public String publicName;
        public String token;
        public int type;
        public String username;
        public List<?> chapterTops;
        public List<?> collectIds;

        @Override
        public String toString() {
            return "DataBean{" +
                    "admin=" + admin +
                    ", coinCount=" + coinCount +
                    ", email='" + email + '\'' +
                    ", icon='" + icon + '\'' +
                    ", id=" + id +
                    ", nickname='" + nickname + '\'' +
                    ", password='" + password + '\'' +
                    ", publicName='" + publicName + '\'' +
                    ", token='" + token + '\'' +
                    ", type=" + type +
                    ", username='" + username + '\'' +
                    ", chapterTops=" + chapterTops +
                    ", collectIds=" + collectIds +
                    '}';
        }


    }

    @Override
    public String toString() {
        return super.toString() + " " +
                "data=" + data;
    }
}
