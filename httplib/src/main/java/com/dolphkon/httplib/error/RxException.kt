package com.dolphkon.httplib.error

import java.io.IOException

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.httplib.error
 * ClassName：RxException
 * Author: kongdexi
 * Date: 2020/11/4 14:10
 * Description:TODO
 * *****************************************************
 */
class RxException : IOException {
    var errorCode: String? = null

    override var message: String? = null

    constructor() {}
    constructor(errorCode: String?, errorMsg: String?) {
        this.errorCode = errorCode
        message = errorMsg
    }

    constructor(errorCode: Int) {
        this.errorCode = errorCode.toString() + ""
    }

    constructor(message: String) {
        errorCode = ErrorCode.ERROR_UNKNOWN
        this.message = message + ""
    }

    constructor(e: Throwable, errorCode: Int) {
        this.errorCode = errorCode.toString() + ""
        message = e.message
    }

    constructor(e: Throwable) {
        errorCode = if (e is RxException) {
            e.errorCode
        } else {
            "-1"
        }
        message = e.message
    }

    override fun toString(): String {
        return "JLException{" +
                "errorCode='" + errorCode + '\'' +
                ", message='" + message + '\'' +
                '}'
    }
}