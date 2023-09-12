package xyz.ratul.ok_http_connection_pooling.feign.interceptors;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class SimpleLoggingInterceptor implements Interceptor {

    private final static Logger LOGGER = LogManager.getLogger(SimpleLogEventsListener.class);

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        LOGGER.info("Intercepted headers: {} from URL: {}", request.headers(), request.url());

        return chain.proceed(request);
    }

}
