package xyz.ratul.ok_http_connection_pooling.feign.interceptors;

import okhttp3.Interceptor;
import okhttp3.Response;

import java.io.IOException;

public class CacheControlResponeInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        return response.newBuilder()
                .header("X-Cache-Control", "no-store")
                .build();
    }
}
