package com.dolphkon.httplib.error;

import androidx.annotation.Nullable;

import java.io.IOException;


/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.httplib.error
 * ClassName：JLException
 * Author: kongdexi
 * Date: 2020/11/4 14:10
 * Description:TODO
 * *****************************************************
 */
public class RxException extends IOException {

    public String errorCode;
    public String message;


    public RxException() {
    }


    public RxException(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.message = errorMsg;
    }

    public RxException(int errorCode) {

        this.errorCode = errorCode + "";
    }

    public RxException(String message) {
        this.errorCode = ErrorCode.ERROR_UNKNOWN;
        this.message = message + "";
    }

    public RxException(Throwable e, int errorCode) {
        this.errorCode = errorCode + "";
        this.message = e.getMessage();
    }

    public RxException(Throwable e) {
        if (e instanceof RxException) {
            errorCode = ((RxException) e).getErrorCode();
        } else {
            errorCode = "-1";
        }
        this.message = e.getMessage();
    }


    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Nullable
    @Override
    public String getMessage() {
        return message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String toString() {
        return "JLException{" +
                "errorCode='" + errorCode + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
