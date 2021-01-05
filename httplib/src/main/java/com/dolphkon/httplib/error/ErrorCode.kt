package com.dolphkon.httplib.error

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.httplib.error
 * ClassName：ErrorCode
 * Author: kongdexi
 * Date: 2020/11/4 14:11
 * Description:TODO
 * *****************************************************
 */
object ErrorCode {
    const val ERROR_UNKNOWN = "-1" //通用
    const val UNKNOWN = -1000 //未知错误
    const val PARSE_ERROR = -1001 //解析错误
    const val NETWORD_ERROR = -1002 //网络错误
    const val HTTP_ERROR = -1003 //协议出错
    const val SSL_ERROR = -1005 //证书出错
    const val TIMEOUT_ERROR = -1006 //连接超时
}