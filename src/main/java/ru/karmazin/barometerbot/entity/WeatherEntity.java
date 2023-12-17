package ru.karmazin.barometerbot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Weather")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeatherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Weather_id")
    private Long id;
    @Column(name = "Weather_main")
    private String main;
    @Column(name = "Weather_description")
    private String description;
}

