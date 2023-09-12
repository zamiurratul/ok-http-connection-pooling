package xyz.ratul.ok_http_connection_pooling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.ratul.ok_http_connection_pooling.dto.WeatherInfoRequest;
import xyz.ratul.ok_http_connection_pooling.dto.WeatherInfoResponse;
import xyz.ratul.ok_http_connection_pooling.feign.WeatherClient;


@RestController
public class HomeController {

    private final WeatherClient weatherClient;

    public HomeController(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    @GetMapping("/")
    @ResponseBody
    public String index() {
        return "Hello World! - Weather-App";
    }

    @PostMapping("/weather")
    public WeatherInfoResponse weather(@RequestBody WeatherInfoRequest request) {
        return weatherClient.getWeather(request);
    }

}
