package ru.karmazin.barometerbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.karmazin.barometerbot.entity.WeatherEntity;

public interface WeatherRepository extends JpaRepository<WeatherEntity, Long> {
}
