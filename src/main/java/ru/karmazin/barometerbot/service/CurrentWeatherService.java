package ru.karmazin.barometerbot.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.karmazin.barometerbot.client.OpenWeatherMapClient;
import ru.karmazin.barometerbot.configuration.OpenWeatherProperties;
import ru.karmazin.barometerbot.dto.currentWeather.CurrentWeatherDto;
import ru.karmazin.barometerbot.entity.CurrentWeatherEntity;
import ru.karmazin.barometerbot.mapper.CurrentWeatherMapper;
import ru.karmazin.barometerbot.repository.CurrentWeatherRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CurrentWeatherService {
    private final CurrentWeatherRepository currentWeatherRepository;
    private final CurrentWeatherMapper currentWeatherMapper;
    private final WeatherService weatherService;
    private final OpenWeatherMapClient openWeatherMapClient;
    private final OpenWeatherProperties openWeatherProperties;

    @Scheduled(cron = "0 0 * * * *")
    private void getAndSaveFromOpenWeatherMap() {
        log.info("Запуск получения погоды по расписанию");
        saveCurrentWeather();
    }

    public CurrentWeatherEntity saveCurrentWeather() {
        Optional<CurrentWeatherEntity> currentWeather = currentWeatherRepository.findByDateAndTimeBetween(
                LocalDate.now(),
                LocalTime.now().withMinute(0).withSecond(0).withNano(0),
                LocalTime.now()
                        .withMinute(LocalTime.MAX.getMinute())
                        .withSecond(LocalTime.MAX.getSecond())
                        .withNano(LocalTime.MAX.getNano())
        );
        if (currentWeather.isPresent()) {
            log.info("Погоды за этот час уже записана");
            return currentWeather.get();
        } else {
            log.info("Погода за этот час еще не получена");
            CurrentWeatherEntity currentWeatherEntity = currentWeatherMapper.pojoToEntity(
                    openWeatherMapClient.getCurrentWeather(
                            openWeatherProperties.getLat(),
                            openWeatherProperties.getLon(),
                            openWeatherProperties.getLang(),
                            openWeatherProperties.getUnits(),
                            openWeatherProperties.getApiKey()));
            weatherService.createIfNotExists(currentWeatherEntity.getWeather());
            log.info("Создание записи с текущей погодой в бд");
            return currentWeatherRepository.save(currentWeatherEntity);
        }
    }

    public Optional<CurrentWeatherDto> getWeather(LocalDateTime dateTime) {
        Optional<CurrentWeatherEntity> currentWeather = currentWeatherRepository.findByDateAndTimeHour(
                dateTime.toLocalDate(), dateTime.toLocalTime().getHour());
        if(currentWeather.isEmpty())
            currentWeather = currentWeatherRepository.findFirstByDateOrderByTimeDesc(dateTime.toLocalDate());
        return currentWeather.map(currentWeatherMapper::entityToDto);
    }

    public Optional<CurrentWeatherDto> getCurrentWeather() {
        return getWeather(LocalDateTime.now());
    }
}
