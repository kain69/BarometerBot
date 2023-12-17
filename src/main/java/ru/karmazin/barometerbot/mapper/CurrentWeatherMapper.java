package ru.karmazin.barometerbot.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.karmazin.barometerbot.dto.currentWeather.CurrentWeatherDto;
import ru.karmazin.barometerbot.dto.currentWeather.WeatherDto;
import ru.karmazin.barometerbot.entity.CurrentWeatherEntity;
import ru.karmazin.barometerbot.entity.WeatherEntity;
import ru.karmazin.barometerbot.pojo.currentWeather.CurrentWeatherPojo;
import ru.karmazin.barometerbot.pojo.currentWeather.WeatherPojo;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class CurrentWeatherMapper {
    private final DateMapper dateMapper;
    private final double PRESSURECOEF = 0.7500637554192;

    public CurrentWeatherDto pojoToDto(CurrentWeatherPojo model) {
        return CurrentWeatherDto.builder()
                .dt(dateMapper.unixToLocalDateTime(model.getDt()))
                .weather(WeatherDto.builder()
                        .main(model.getWeather().getFirst().getMain())
                        .description(model.getWeather().getFirst().getDescription())
                        .build())
                .temp(model.getMain().getTemp())
                .feelsLike(model.getMain().getFeelsLike())
                .pressure(Math.round(model.getMain().getPressure() * PRESSURECOEF))
                .humidity(model.getMain().getHumidity())
                .clouds(model.getClouds().getAll())
                .build();
    }

    public CurrentWeatherEntity pojoToEntity(CurrentWeatherPojo model) {
        return CurrentWeatherEntity.builder()
                .date(dateMapper.unixToLocalDateTime(model.getDt()).toLocalDate())
                .time(dateMapper.unixToLocalDateTime(model.getDt()).toLocalTime())
                .weather(weatherPojoToEntity(model.getWeather().getFirst()))
                .temp(model.getMain().getTemp())
                .feelsLike(model.getMain().getFeelsLike())
                .pressure(Math.round(model.getMain().getPressure() * PRESSURECOEF))
                .humidity(model.getMain().getHumidity())
                .clouds(model.getClouds().getAll())
                .build();
    }

    public CurrentWeatherDto entityToDto(CurrentWeatherEntity model) {
        return CurrentWeatherDto.builder()
                .dt(LocalDateTime.of(model.getDate(), model.getTime()))
                .weather(weatherEntityToDto(model.getWeather()))
                .temp(model.getTemp())
                .feelsLike(model.getFeelsLike())
                .pressure(model.getPressure())
                .humidity(model.getHumidity())
                .clouds(model.getClouds())
                .build();
    }

    public WeatherDto weatherEntityToDto(WeatherEntity model) {
        return WeatherDto.builder()
                .main(model.getMain())
                .description(model.getDescription())
                .build();
    }

    public WeatherEntity weatherPojoToEntity(WeatherPojo model) {
        return WeatherEntity.builder()
                .id(model.getId())
                .main(model.getMain())
                .description(model.getDescription())
                .build();
    }
}
