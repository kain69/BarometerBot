package ru.karmazin.barometerbot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.karmazin.barometerbot.dto.currentWeather.CurrentWeatherDto;
import ru.karmazin.barometerbot.service.CurrentWeatherService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class WeatherController {
    private final CurrentWeatherService currentWeatherService;

    @GetMapping("/weather")
    public ResponseEntity<CurrentWeatherDto> getCurrentWeather(@RequestParam(value = "date", required = false) LocalDate date) {
        Optional<CurrentWeatherDto> currentWeatherDto;
        if (date == null) {
            currentWeatherDto = currentWeatherService.getCurrentWeather();
        } else {
            currentWeatherDto = currentWeatherService.getWeather(LocalDateTime.of(date, LocalTime.now()));
        }
        if(currentWeatherDto.isPresent())
            return ResponseEntity.ok(currentWeatherDto.get());
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
