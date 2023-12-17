drop table current_weather;
drop table weather;

create table weather
(
    weather_id          bigint primary key not null,
    weather_main        varchar(50)        not null,
    weather_description varchar(50)        not null
);

create table current_weather
(
    current_weather_id           bigserial primary key not null,
    current_weather_date         date                  not null,
    current_weather_time_insert  time                  not null,
    current_weather_time_weather time                  not null,
    weather_id                   bigint
        references weather (weather_id)                not null,
    current_weather_temp         double precision      not null,
    current_weather_feels_like   double precision      not null,
    current_weather_pressure     bigint                not null,
    current_weather_humidity     bigint                not null,
    current_weather_clouds       bigint                not null,
    current_weather_sunrise      timestamp             not null,
    current_weather_sunset       timestamp             not null
);