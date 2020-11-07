package com.dolphkon.httplib.base;
import com.dolphkon.httplib.BuildConfig;
import com.dolphkon.httplib.utils.LogUtil;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Function;
import okhttp3.ResponseBody;

/**
 * ****************************************************
 * Project: WanandroidClient
 * PackageName: com.dolphkon.httplib.base
 * ClassName：ParseDateFromServerTransformer
 * Author: kongdexi
 * Date: 2020/11/3 15:31
 * Description:TODO
 * *****************************************************
 */
public class ParseDateFromServerTransformer<T extends BaseResponse> implements ObservableTransformer<ResponseBody, T> {
    @Override
    public ObservableSource<T> apply(Observable<ResponseBody> upstream) {
        return upstream.flatMap(new Function<ResponseBody, ObservableSource<T>>() {

            @Override
            public ObservableSource<T> apply(ResponseBody responseBody) throws Exception {
                LogUtil.e("value_thread_ObservableSource:"+Thread.currentThread().getName());
                String response = null;
                try {
                    response = responseBody.string();
                    Type type = getType();
                    T data = new Gson().fromJson(response, type);
                    if (data == null) {
                        return Observable.error(new JsonParseException("解析异常"));
                    }

                    if (data.isOk()) {
                        return Observable.just(data);
                    } else {
                        return Observable.error(new JsonParseException("解析异常"));
                    }

                } catch (Exception e) {
                    if (BuildConfig.DEBUG) {
                        e.printStackTrace();
                    }
                    return Observable.error(e);
                } finally {
                    responseBody.close();
                }
            }
        });
    }


    //获取泛型类型
    private Type getType() {
        Type superclass = getClass().getGenericSuperclass();
        if (superclass instanceof Class) {
            throw new RuntimeException("须传入指定类型");
        }
        ParameterizedType parameterized = (ParameterizedType) superclass;
        Type type = parameterized.getActualTypeArguments()[0];
        return type;
    }


}
