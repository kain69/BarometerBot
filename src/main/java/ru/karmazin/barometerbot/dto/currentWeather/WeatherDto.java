package ru.karmazin.barometerbot.dto.currentWeather;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WeatherDto {
    private String main;
    private String description;
}
