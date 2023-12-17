
package ru.karmazin.barometerbot.pojo.currentWeather;

import jakarta.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "all"
})
@Generated("jsonschema2pojo")
public class CloudsPojo {

    @JsonProperty("all")
    private Long all;

    @JsonProperty("all")
    public Long getAll() {
        return all;
    }

    @JsonProperty("all")
    public void setAll(Long all) {
        this.all = all;
    }

}
