package ru.karmazin.barometerbot.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class OpenWeatherProperties {
    @Value("${weather.lat}")
    private Double lat;
    @Value("${weather.lon}")
    private Double lon;
    @Value("${weather.units}")
    private String units;
    @Value("${weather.lang}")
    private String lang;
    @Value("${weather.apiKey}")
    private String apiKey;
}
