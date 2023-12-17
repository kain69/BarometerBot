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
@Table(name = "Current_Weather")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrentWeatherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Current_Weather_id")
    private Long id;
    @Column(name = "Current_Weather_date")
    private LocalDate date;
    @Column(name = "Current_Weather_time")
    private LocalTime time;
    //todo: Время добавления в бд отдельно сделать и всю логику со временем на него привязать.
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Weather_id", referencedColumnName = "Weather_id")
    private WeatherEntity weather;
    @Column(name = "Current_Weather_temp")
    private Double temp;
    @Column(name = "Current_Weather_Feels_Like")
    private Double feelsLike;
    @Column(name = "Current_Weather_pressure")
    private Long pressure;
    @Column(name = "Current_Weather_humidity")
    private Long humidity;
    @Column(name = "Current_Weather_clouds")
    private Long clouds;
    @Column(name = "Current_Weather_sunrise")
    private LocalDateTime sunrise;
    @Column(name = "Current_Weather_sunset")
    private LocalDateTime sunset;
}
