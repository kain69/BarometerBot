package ru.karmazin.barometerbot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "CurrentWeather")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrentWeatherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CurrentWeather_id")
    private Long id;
    @Column(name = "CurrentWeather_date")
    private LocalDate date;
    @Column(name = "CurrentWeather_time")
    private LocalTime time;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Weather_id", referencedColumnName = "Weather_id")
    private WeatherEntity weather;
    @Column(name = "CurrentWeather_temp")
    private Double temp;
    @Column(name = "CurrentWeather_feelsLike")
    private Double feelsLike;
    @Column(name = "CurrentWeather_pressure")
    private Long pressure;
    @Column(name = "CurrentWeather_humidity")
    private Long humidity;
    @Column(name = "CurrentWeather_clouds")
    private Long clouds;
    @Column(name = "CurrentWeather_sunrise")
    private LocalDateTime sunrise;
    @Column(name = "CurrentWeather_sunset")
    private LocalDateTime sunset;

}
