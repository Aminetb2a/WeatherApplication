package patika.dev.definex.weaterApp.model.visualCrossing.forecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentConditionsDTO {
    @JsonProperty("wdir")
    private Double wdir;
    @JsonProperty("temp")
    private Double temp;
    @JsonProperty("sunrise")
    private String sunrise;
    @JsonProperty("visibility")
    private Double visibility;
    @JsonProperty("wspd")
    private Double wspd;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("stations")
    private String stations;
    @JsonProperty("heatindex")
    private Object heatindex;
    @JsonProperty("cloudcover")
    private Object cloudcover;
    @JsonProperty("datetime")
    private String datetime;
    @JsonProperty("precip")
    private Double precip;
    @JsonProperty("moonphase")
    private Double moonphase;
    @JsonProperty("snowdepth")
    private Object snowdepth;
    @JsonProperty("sealevelpressure")
    private Double sealevelpressure;
    @JsonProperty("dew")
    private Double dew;
    @JsonProperty("sunset")
    private String sunset;
    @JsonProperty("humidity")
    private Double humidity;
    @JsonProperty("wgust")
    private Object wgust;
    @JsonProperty("windchill")
    private Object windchill;
}
