package ru.karmazin.barometerbot.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.karmazin.barometerbot.pojo.currentWeather.CurrentWeather;

@FeignClient(name = "openweather",
url = "https://api.openweathermap.org/data/2.5/")
public interface OpenWeatherMapClient {

    @GetMapping(value = "/weather")
    CurrentWeather getCurrentWeather(@RequestParam("lat") Double lat,
                                     @RequestParam("lon") Double lon,
                                     @RequestParam("lang") String lang,
                                     @RequestParam("units") String units,
                                     @RequestParam("appid") String apiKey);

}
