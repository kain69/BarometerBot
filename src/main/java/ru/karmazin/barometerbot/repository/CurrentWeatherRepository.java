package ru.karmazin.barometerbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.karmazin.barometerbot.entity.CurrentWeatherEntity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

public interface CurrentWeatherRepository extends JpaRepository<CurrentWeatherEntity, Long> {
    Optional<CurrentWeatherEntity> findByDateAndTimeBetween(LocalDate date, LocalTime timeStart, LocalTime timeEnd);

    @Query("SELECT c FROM CurrentWeatherEntity c WHERE c.date = :date AND HOUR(c.time) = :hour")
    Optional<CurrentWeatherEntity> findByDateAndTimeHour(LocalDate date, int hour);

    Optional<CurrentWeatherEntity> findFirstByDateOrderByTimeDesc(LocalDate date);
}
