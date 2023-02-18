package patika.dev.definex.weaterApp.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ValuesDTO {
    @JsonProperty("wdir")
    private Double wdir;
    @JsonProperty("uvindex")
    private Double uvindex;
    @JsonProperty("datetimeStr")
    private String datetimeStr;
    @JsonProperty("preciptype")
    private String preciptype;
    @JsonProperty("cin")
    private Double cin;
    @JsonProperty("cloudcover")
    private Double cloudcover;
    @JsonProperty("pop")
    private Double pop;
    @JsonProperty("datetime")
    private Long datetime;
    @JsonProperty("precip")
    private Double precip;
    @JsonProperty("solarradiation")
    private Double solarradiation;
    @JsonProperty("dew")
    private Double dew;
    @JsonProperty("humidity")
    private Double humidity;
    @JsonProperty("temp")
    private Double temp;
    @JsonProperty("visibility")
    private Double visibility;
    @JsonProperty("wspd")
    private Double wspd;
    @JsonProperty("severerisk")
    private Double severerisk;
    @JsonProperty("solarenergy")
    private Double solarenergy;
    @JsonProperty("heatindex")
    private Object heatindex;
    @JsonProperty("snowdepth")
    private Double snowdepth;
    @JsonProperty("sealevelpressure")
    private Double sealevelpressure;
    @JsonProperty("snow")
    private Double snow;
    @JsonProperty("wgust")
    private Double wgust;
    @JsonProperty("conditions")
    private String conditions;
    @JsonProperty("windchill")
    private Object windchill;
    @JsonProperty("cape")
    private Double cape;
}
