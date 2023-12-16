package ru.karmazin.barometerbot.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.karmazin.barometerbot.dto.currentWeather.CurrentWeatherDto;
import ru.karmazin.barometerbot.dto.currentWeather.MainDto;
import ru.karmazin.barometerbot.dto.currentWeather.WeatherDto;
import ru.karmazin.barometerbot.pojo.currentWeather.CurrentWeather;

@Component
@RequiredArgsConstructor
public class CurrentWeatherMapper {
    private final DateMapper dateMapper;
    private final double PRESSURECOEF = 0.7500637554192;

    public CurrentWeatherDto toDto(CurrentWeather model) {
        CurrentWeatherDto dto = new CurrentWeatherDto();
        dto.setDt(dateMapper.unixToLocalDateTime(model.getDt()));
        dto.setMain(MainDto.builder()
                .temp(model.getMain().getTemp())
                .feelsLike(model.getMain().getFeelsLike())
                .pressure(Math.round(model.getMain().getPressure() * PRESSURECOEF))
                .humidity(model.getMain().getHumidity())
                .clouds(model.getClouds().getAll())
                .build());
        dto.setWeather(WeatherDto.builder()
                .main(model.getWeather().getFirst().getMain())
                .description(model.getWeather().getFirst().getDescription())
                .build());
        return dto;
    }
}
