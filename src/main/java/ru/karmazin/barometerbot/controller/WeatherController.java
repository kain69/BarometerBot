package ru.karmazin.barometerbot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.karmazin.barometerbot.client.OpenWeatherMapClient;
import ru.karmazin.barometerbot.configuration.OpenWeatherProperties;
import ru.karmazin.barometerbot.dto.currentWeather.CurrentWeatherDto;
import ru.karmazin.barometerbot.mapper.CurrentWeatherMapper;

@RestController
@RequestMapping("/api/weather")
@RequiredArgsConstructor
public class WeatherController {
    private final OpenWeatherMapClient openWeatherMapClient;
    private final OpenWeatherProperties openWeatherProperties;
    private final CurrentWeatherMapper currentWeatherMapper;

    @GetMapping("/currentWeather")
    public CurrentWeatherDto getCurrentWeather() {
        return currentWeatherMapper.entityToDto(
                currentWeatherMapper.pojoToEntity(
                        openWeatherMapClient.getCurrentWeather(
                                openWeatherProperties.getLat(),
                                openWeatherProperties.getLon(),
                                openWeatherProperties.getLang(),
                                openWeatherProperties.getUnits(),
                                openWeatherProperties.getApiKey())));
    }

}
