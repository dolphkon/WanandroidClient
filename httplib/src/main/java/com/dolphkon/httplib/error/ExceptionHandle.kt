package com.dolphkon.httplib.error

import android.net.ParseException
import com.dolphkon.httplib.BuildConfig
import com.dolphkon.httplib.utils.LogUtil
import com.google.gson.JsonParseException
import org.apache.http.conn.ConnectTimeoutException
import org.json.JSONException
import retrofit2.HttpException
import java.io.IOException
import java.io.PrintWriter
import java.io.StringWriter
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.net.ssl.SSLHandshakeException

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.httplib.utils
 * ClassName：ExceptionHandle
 * Author: kongdexi
 * Date: 2020/10/14 15:27
 * Description:TODO
 * *****************************************************
 */
object ExceptionHandle {
    private const val UNAUTHORIZED = 401
    private const val FORBIDDEN = 403
    private const val NOT_FOUND = 404
    private const val REQUEST_TIMEOUT = 408
    private const val INTERNAL_SERVER_ERROR = 500
    private const val BAD_GATEWAY = 502
    private const val SERVICE_UNAVAILABLE = 503
    private const val GATEWAY_TIMEOUT = 504
    fun handleException(e: Throwable): RxException {
        e.printStackTrace()
        if (BuildConfig.DEBUG) {
            LogUtil.d(errInfo(Exception(e)))
        }
        val ex: RxException
        return if (e is HttpException) {
            ex = RxException(e, ErrorCode.HTTP_ERROR)
            when (e.code()) {
                GATEWAY_TIMEOUT, REQUEST_TIMEOUT -> ex.message = "网络超时"
                UNAUTHORIZED, FORBIDDEN, NOT_FOUND, INTERNAL_SERVER_ERROR, BAD_GATEWAY, SERVICE_UNAVAILABLE -> ex.message = "网络错误"
                else -> ex.message = "网络错误"
            }
            ex
        } else if (e is JsonParseException
                || e is JSONException
                || e is ParseException) {
            ex = RxException(e, ErrorCode.PARSE_ERROR)
            ex.message = "解析错误"
            ex
        } else if (e is ConnectException) {
            ex = RxException(e, ErrorCode.NETWORD_ERROR)
            ex.message = "网络连接失败"
            ex
        } else if (e is SSLHandshakeException) {
            ex = RxException(e, ErrorCode.SSL_ERROR)
            ex.message = "证书错误"
            ex
        } else if (e is ConnectTimeoutException) {
            ex = RxException(e, ErrorCode.TIMEOUT_ERROR)
            ex.message = "连接超时"
            ex
        } else if (e is SocketTimeoutException) {
            ex = RxException(e, ErrorCode.TIMEOUT_ERROR)
            ex.message = "连接超时"
            ex
        } else if (e is UnknownHostException) {
            ex = RxException(e, ErrorCode.TIMEOUT_ERROR)
            ex.message = "网络错误"
            ex
        } else if (e is RxException) {
            e
        } else {
            ex = RxException(e, ErrorCode.UNKNOWN)
            ex.message = "处理失败" + e.javaClass.simpleName
            ex
        }
    }
    /**
     * 将出错的栈信息输出到printWriter中
     */
    fun errInfo(e: Exception): String {
        var sw: StringWriter? = null
        var pw: PrintWriter? = null
        try {
            sw = StringWriter()
            pw = PrintWriter(sw)
            e.printStackTrace(pw)
            pw.flush()
            sw.flush()
        } finally {
            if (sw != null) {
                try {
                    sw.close()
                } catch (e1: IOException) {
                    e1.printStackTrace()
                }
            }
            pw?.close()
        }
        return sw.toString()
    }
}