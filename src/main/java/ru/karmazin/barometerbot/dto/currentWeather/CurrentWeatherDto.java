package ru.karmazin.barometerbot.dto.currentWeather;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CurrentWeatherDto {
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime dt;
    private WeatherDto weather;
    private Double temp;
    private Double feelsLike;
    private Long pressure;
    private Long humidity;
    private Long clouds;
}
