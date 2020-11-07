package com.dolphkon.httplib.error;

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
public class ErrorCode {
    public static final String ERROR_UNKNOWN = "-1";//通用
    public static final int UNKNOWN = -1000; //未知错误
    public static final int PARSE_ERROR = -1001;  //解析错误
    public static final int NETWORD_ERROR = -1002;  //网络错误
    public static final int HTTP_ERROR = -1003;   //协议出错
    public static final int SSL_ERROR = -1005;    //证书出错
    public static final int TIMEOUT_ERROR = -1006;  //连接超时


}
