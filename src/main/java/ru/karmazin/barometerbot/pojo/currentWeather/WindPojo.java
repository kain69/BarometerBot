
package ru.karmazin.barometerbot.pojo.currentWeather;

import jakarta.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "speed",
    "deg"
})
@Generated("jsonschema2pojo")
public class WindPojo {

    @JsonProperty("speed")
    private Long speed;
    @JsonProperty("deg")
    private Long deg;

    @JsonProperty("speed")
    public Long getSpeed() {
        return speed;
    }

    @JsonProperty("speed")
    public void setSpeed(Long speed) {
        this.speed = speed;
    }

    @JsonProperty("deg")
    public Long getDeg() {
        return deg;
    }

    @JsonProperty("deg")
    public void setDeg(Long deg) {
        this.deg = deg;
    }

}
