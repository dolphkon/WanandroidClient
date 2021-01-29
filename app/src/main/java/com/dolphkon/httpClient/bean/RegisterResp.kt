package com.dolphkon.httpClient.bean

import com.dolphkon.httplib.base.BaseResponse

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.httpClient.bean
 * ClassName：
 * Author: kongdexi
 * Date: 2020/11/3 11:26
 * Description:TODO
 * *****************************************************
 */
class RegisterResp(ret_code: String?, ret_msg: String?) : BaseResponse(ret_code, ret_msg) {
    var data: DataBean? = null

    inner class DataBean {
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
        var admin = false
        var coinCount = 0
        var email: String? = null
        var icon: String? = null
        var id = 0
        var nickname: String? = null
        var password: String? = null
        var publicName: String? = null
        var token: String? = null
        var type = 0
        var username: String? = null
        var chapterTops: List<*>? = null
        var collectIds: List<*>? = null
        override fun toString(): String {
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
                    '}'
        }
    }

    override fun toString(): String {
        return super.toString() + " " +
                "data=" + data
    }
}