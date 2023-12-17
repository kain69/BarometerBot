package ru.karmazin.barometerbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.karmazin.barometerbot.entity.CurrentWeatherEntity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

public interface CurrentWeatherRepository extends JpaRepository<CurrentWeatherEntity, Long> {
    Optional<CurrentWeatherEntity> findByDateAndTimeBetween(LocalDate date, LocalTime timeStart, LocalTime timeEnd);
    Optional<CurrentWeatherEntity> findByDateAndTimeHour(LocalDate date, int time_hour);
}
