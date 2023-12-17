
package ru.karmazin.barometerbot.pojo.currentWeather;

import java.util.List;
import jakarta.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "coord",
    "weather",
    "base",
    "main",
    "visibility",
    "wind",
    "clouds",
    "dt",
    "sys",
    "timezone",
    "id",
    "name",
    "cod"
})
@Generated("jsonschema2pojo")
public class CurrentWeatherPojo {

    @JsonProperty("coord")
    private CoordPojo coordPojo;
    @JsonProperty("weather")
    private List<WeatherPojo> weatherPojo;
    @JsonProperty("base")
    private String base;
    @JsonProperty("main")
    private MainPojo mainPojo;
    @JsonProperty("visibility")
    private Long visibility;
    @JsonProperty("wind")
    private WindPojo windPojo;
    @JsonProperty("clouds")
    private CloudsPojo cloudsPojo;
    @JsonProperty("dt")
    private Long dt;
    @JsonProperty("sys")
    private SysPojo sysPojo;
    @JsonProperty("timezone")
    private Long timezone;
    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("cod")
    private Long cod;

    @JsonProperty("coord")
    public CoordPojo getCoord() {
        return coordPojo;
    }

    @JsonProperty("coord")
    public void setCoord(CoordPojo coordPojo) {
        this.coordPojo = coordPojo;
    }

    @JsonProperty("weather")
    public List<WeatherPojo> getWeather() {
        return weatherPojo;
    }

    @JsonProperty("weather")
    public void setWeather(List<WeatherPojo> weatherPojo) {
        this.weatherPojo = weatherPojo;
    }

    @JsonProperty("base")
    public String getBase() {
        return base;
    }

    @JsonProperty("base")
    public void setBase(String base) {
        this.base = base;
    }

    @JsonProperty("main")
    public MainPojo getMain() {
        return mainPojo;
    }

    @JsonProperty("main")
    public void setMain(MainPojo mainPojo) {
        this.mainPojo = mainPojo;
    }

    @JsonProperty("visibility")
    public Long getVisibility() {
        return visibility;
    }

    @JsonProperty("visibility")
    public void setVisibility(Long visibility) {
        this.visibility = visibility;
    }

    @JsonProperty("wind")
    public WindPojo getWind() {
        return windPojo;
    }

    @JsonProperty("wind")
    public void setWind(WindPojo windPojo) {
        this.windPojo = windPojo;
    }

    @JsonProperty("clouds")
    public CloudsPojo getClouds() {
        return cloudsPojo;
    }

    @JsonProperty("clouds")
    public void setClouds(CloudsPojo cloudsPojo) {
        this.cloudsPojo = cloudsPojo;
    }

    @JsonProperty("dt")
    public Long getDt() {
        return dt;
    }

    @JsonProperty("dt")
    public void setDt(Long dt) {
        this.dt = dt;
    }

    @JsonProperty("sys")
    public SysPojo getSys() {
        return sysPojo;
    }

    @JsonProperty("sys")
    public void setSys(SysPojo sysPojo) {
        this.sysPojo = sysPojo;
    }

    @JsonProperty("timezone")
    public Long getTimezone() {
        return timezone;
    }

    @JsonProperty("timezone")
    public void setTimezone(Long timezone) {
        this.timezone = timezone;
    }

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("cod")
    public Long getCod() {
        return cod;
    }

    @JsonProperty("cod")
    public void setCod(Long cod) {
        this.cod = cod;
    }

}
