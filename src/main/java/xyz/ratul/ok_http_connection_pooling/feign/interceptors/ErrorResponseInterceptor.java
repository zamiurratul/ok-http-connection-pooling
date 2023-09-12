package xyz.ratul.ok_http_connection_pooling.feign.interceptors;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Response;

import java.io.IOException;

public class ErrorResponseInterceptor implements Interceptor {

    public static final MediaType APPLICATION_JSON = MediaType.get("application/json; charset=utf-8");

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());

        /*
        if (!response.isSuccessful()) {
            Gson gson = new Gson();
            String body = gson.toJson(
                    new ErrorMessage(response.code(), "The response from the server was not OK"));
            ResponseBody responseBody = ResponseBody.create(body, APPLICATION_JSON);

            ResponseBody originalBody = response.body();
            if (originalBody != null) {
                originalBody.close();
            }

            return response.newBuilder().body(responseBody).build();
        }
         */
        return response;
    }
}
