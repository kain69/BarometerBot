package ru.karmazin.barometerbot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.karmazin.barometerbot.entity.WeatherEntity;
import ru.karmazin.barometerbot.repository.WeatherRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WeatherService {
    private final WeatherRepository weatherRepository;

    public void createIfNotExists(WeatherEntity weather) {
        Optional<WeatherEntity> weatherEntity = weatherRepository.findById(weather.getId());
        if(weatherEntity.isPresent())
            return;
        weatherRepository.save(weather);
    }
}
