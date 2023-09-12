package xyz.ratul.ok_http_connection_pooling.feign.config;

import feign.Logger;
import okhttp3.ConnectionPool;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.ratul.ok_http_connection_pooling.feign.interceptors.CacheControlResponeInterceptor;
import xyz.ratul.ok_http_connection_pooling.feign.interceptors.SimpleLogEventsListener;
import xyz.ratul.ok_http_connection_pooling.feign.interceptors.SimpleLoggingInterceptor;

import java.util.concurrent.TimeUnit;

@Configuration
public class WeatherClientConfig {
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public feign.okhttp.OkHttpClient client() {

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        ConnectionPool connectionPool = new ConnectionPool(60, 60, TimeUnit.SECONDS);

        okhttp3.OkHttpClient okHttpClient = new okhttp3.OkHttpClient.Builder()
                .connectionPool(connectionPool)
                .connectTimeout(10000, TimeUnit.MILLISECONDS)
                .readTimeout(30000, TimeUnit.MILLISECONDS)
                .writeTimeout(10000, TimeUnit.MILLISECONDS)
                .addInterceptor(loggingInterceptor)
                .addInterceptor(new SimpleLoggingInterceptor())
                .addInterceptor(new CacheControlResponeInterceptor())
                .eventListener(new SimpleLogEventsListener())
                .build();

        return new feign.okhttp.OkHttpClient(okHttpClient);
    }

    @Bean
    feign.Request.Options options() {
        return new feign.Request.Options(10000, 30000, true);
    }
}
