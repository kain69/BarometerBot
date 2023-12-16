package ru.karmazin.barometerbot.dto.currentWeather;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CurrentWeatherDto {
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime dt;
    private WeatherDto weather;
    private MainDto main;
}
