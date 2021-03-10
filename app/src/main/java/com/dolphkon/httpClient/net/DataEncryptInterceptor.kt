package com.dolphkon.httpClient.net

import com.dolphkon.httplib.utils.LogUtil
import okhttp3.FormBody
import okhttp3.Interceptor
import okhttp3.Response
import okio.Buffer
import java.io.IOException
import java.net.URLDecoder

class DataEncryptInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response { //请求
        val request = chain.request()
        val oldRequestBody = request.body()
        var oldBodyStr = ""
        if (oldRequestBody != null) {
            val requestBuffer = Buffer()
            oldRequestBody.writeTo(requestBuffer)
            oldBodyStr = requestBuffer.readUtf8()
            requestBuffer.close()
        }
        val method = request.method()
        if ("POST" == method) {
            val sb = StringBuilder()
            if (request.body() is FormBody) {
                val body = request.body() as FormBody?
                for (i in 0 until body!!.size()) {
                    if (body.encodedName(i) != null && body.encodedName(i) == "common") {
                        sb.append("\"" + body.encodedName(i) + "\"" + ":" + body.encodedValue(i) + ",")
                    } else {
                        sb.append("\"" + body.encodedName(i) + "\"" + ":\"" + body.encodedValue(i) + "\",")
                    }
                }
                sb.delete(sb.length - 1, sb.length)
                LogUtil.e("请求：\n" + request.url() + "\n{" + URLDecoder.decode(sb.toString(), "utf-8") + "}")
            } else {
                LogUtil.e("请求：\n" + request.url() + "," + oldBodyStr)
            }
        } else {
            LogUtil.e(String.format("请求：\n%s\n%s",
                    request.url(), request.headers()))
        }
        //响应
        val response = chain.proceed(request)
        val responseBody = response.peekBody(1024 * 1024.toLong())
        LogUtil.e("响应：\n" + responseBody.string() + "")
        return response
    }
}