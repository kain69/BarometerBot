package ru.karmazin.barometerbot.dto.currentWeather;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MainDto {
    private Double temp;
    private Double feelsLike;
    private Long pressure;
    private Long humidity;
    private Long clouds;
}
