package ru.karmazin.barometerbot.mapper;

import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
public class DateMapper {
    private static final ZoneOffset UTC5 = ZoneOffset.ofHours(5); // UTC+5
    public LocalDateTime unixToLocalDateTime(long unix) {
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(unix), UTC5);
    }
}
