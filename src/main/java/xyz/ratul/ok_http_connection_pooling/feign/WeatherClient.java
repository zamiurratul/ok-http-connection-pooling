package xyz.ratul.ok_http_connection_pooling.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xyz.ratul.ok_http_connection_pooling.dto.WeatherInfoRequest;
import xyz.ratul.ok_http_connection_pooling.dto.WeatherInfoResponse;
import xyz.ratul.ok_http_connection_pooling.feign.config.WeatherClientConfig;

@FeignClient(name = "WeatherClient", url = "${feign.client.url.weather}", configuration = WeatherClientConfig.class)
public interface WeatherClient {
    @RequestMapping(method = RequestMethod.POST, value = "/weather")
    WeatherInfoResponse getWeather(WeatherInfoRequest request);
}
