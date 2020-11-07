package com.dolphkon.httplib.error;
import android.net.ParseException;
import com.dolphkon.httplib.utils.LogUtil;
import com.google.gson.JsonParseException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.ConnectException;
import retrofit2.HttpException;

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.httplib.utils
 * ClassName：
 * Author: kongdexi
 * Date: 2020/10/14 15:27
 * Description:TODO
 * *****************************************************
 */
public class ExceptionHandle {
    private static final int UNAUTHORIZED = 401;
    private static final int FORBIDDEN = 403;
    private static final int NOT_FOUND = 404;
    private static final int REQUEST_TIMEOUT = 408;
    private static final int INTERNAL_SERVER_ERROR = 500;
    private static final int BAD_GATEWAY = 502;
    private static final int SERVICE_UNAVAILABLE = 503;
    private static final int GATEWAY_TIMEOUT = 504;

    public static RxException handleException(Throwable e) {
        e.printStackTrace();
        LogUtil.d(errInfo(new Exception(e)));
        RxException ex;
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            ex = new RxException(e, ERROR.HTTP_ERROR);
            switch (httpException.code()) {
                case GATEWAY_TIMEOUT:
                case REQUEST_TIMEOUT:
                    ex.message = "网络超时";
                    break;
                case UNAUTHORIZED:
                case FORBIDDEN:
                case NOT_FOUND:

                case INTERNAL_SERVER_ERROR:
                case BAD_GATEWAY:
                case SERVICE_UNAVAILABLE:
                default:
                    ex.message = "网络错误";
                    break;
            }
            return ex;
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException) {
            ex = new RxException(e, ERROR.PARSE_ERROR);
            ex.message = "解析错误";
            return ex;
        } else if (e instanceof ConnectException) {
            ex = new RxException(e, ERROR.NETWORD_ERROR);
            ex.message = "网络连接失败";
            return ex;
        } else if (e instanceof javax.net.ssl.SSLHandshakeException) {
            ex = new RxException(e, ERROR.SSL_ERROR);
            ex.message = "证书错误";
            return ex;
        } else if (e instanceof ConnectTimeoutException) {
            ex = new RxException(e, ERROR.TIMEOUT_ERROR);
            ex.message = "连接超时";
            return ex;
        } else if (e instanceof java.net.SocketTimeoutException) {
            ex = new RxException(e, ERROR.TIMEOUT_ERROR);
            ex.message = "连接超时";
            return ex;
        } else if (e instanceof java.net.UnknownHostException) {
            ex = new RxException(e, ERROR.TIMEOUT_ERROR);
            ex.message = "网络错误";
            return ex;
        } else if (e instanceof RxException) {
            return (RxException) e;
        } else {
            ex = new RxException(e, ERROR.UNKNOWN);
            ex.message = "处理失败" + e.getClass().getSimpleName();
            return ex;
        }
    }


    /**
     * 约定异常
     */
    public class ERROR {
        /**
         * 未知错误
         */
        public static final int UNKNOWN = -1000;
        /**
         * 解析错误
         */
        public static final int PARSE_ERROR = -1001;
        /**
         * 网络错误
         */
        public static final int NETWORD_ERROR = -1002;
        /**
         * 协议出错
         */
        public static final int HTTP_ERROR = -1003;

        /**
         * 证书出错
         */
        public static final int SSL_ERROR = -1005;

        /**
         * 连接超时
         */
        public static final int TIMEOUT_ERROR = -1006;

    }

    public static String errInfo(Exception e) {
        StringWriter sw = null;
        PrintWriter pw = null;
        try {
            sw = new StringWriter();
            pw = new PrintWriter(sw);
            // 将出错的栈信息输出到printWriter中
            e.printStackTrace(pw);
            pw.flush();
            sw.flush();
        } finally {
            if (sw != null) {
                try {
                    sw.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (pw != null) {
                pw.close();
            }
        }
        return sw.toString();
    }
}
