package com.dolphkon.httplib.base;

import com.dolphkon.httplib.ResultCode;

import java.io.Serializable;

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.httplib.base
 * ClassName：BaseResponse
 * Author: kongdexi
 * Date: 2020/10/14 16:41
 * Description:TODO
 * *****************************************************
 */
public class BaseResponse implements Serializable {

    private String errorCode;
    private String errorMsg;


    @Override
    public String toString() {
        return "BaseResponse{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }

    public String getRet_code() {
        return errorCode;
    }

    public void setRet_code(String ret_code) {
        this.errorCode = ret_code;
    }

    public String getRet_msg() {
        return errorMsg;
    }

    public void setRet_msg(String ret_msg) {
        this.errorMsg = ret_msg;
    }

    public boolean isOk() {
        return ResultCode.CODE_SUCCESS.equals(errorCode);
    }

}
