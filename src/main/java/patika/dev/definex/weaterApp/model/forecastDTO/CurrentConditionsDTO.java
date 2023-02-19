package patika.dev.definex.weaterApp.model.forecastDTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentConditionsDTO {
    @ApiModelProperty(notes = "wdir", example = "252.0")
    @JsonProperty("wdir")
    private Double wdir;
    @ApiModelProperty(notes = "temp", example = "51.7")
    @JsonProperty("temp")
    private Double temp;
    @ApiModelProperty(notes = "sunrise", example = "2023-02-18T07:09:12Z")
    @JsonProperty("sunrise")
    private String sunrise;
    @ApiModelProperty(notes = "visibility", example = "6.2")
    @JsonProperty("visibility")
    private Double visibility;
    @ApiModelProperty(notes = "wspd", example = "14.5")
    @JsonProperty("wspd")
    private Double wspd;
    @ApiModelProperty(notes = "icon", example = "cloudy")
    @JsonProperty("icon")
    private String icon;
    @ApiModelProperty(notes = "stations", example = "")
    @JsonProperty("stations")
    private String stations;
    @JsonProperty("heatindex")
    private Object heatindex;
    @ApiModelProperty(notes = "cloudcover", example = "88.0")
    @JsonProperty("cloudcover")
    private Object cloudcover;
    @ApiModelProperty(notes = "datetime", example = "2023-02-18T22:26:05Z")
    @JsonProperty("datetime")
    private String datetime;
    @ApiModelProperty(notes = "precip", example = "0.0")
    @JsonProperty("precip")
    private Double precip;
    @ApiModelProperty(notes = "moonphase", example = "0.94")
    @JsonProperty("moonphase")
    private Double moonphase;
    @ApiModelProperty(notes = "snowdepth", example = "0.0")
    @JsonProperty("snowdepth")
    private Object snowdepth;
    @ApiModelProperty(notes = "sealevelpressure", example = "1022.0")
    @JsonProperty("sealevelpressure")
    private Double sealevelpressure;
    @ApiModelProperty(notes = "dew", example = "45.1")
    @JsonProperty("dew")
    private Double dew;
    @ApiModelProperty(notes = "sunset", example = "2023-02-18T17:20:35Z")
    @JsonProperty("sunset")
    private String sunset;
    @ApiModelProperty(notes = "humidity", example = "78.5")
    @JsonProperty("humidity")
    private Double humidity;
    @ApiModelProperty(notes = "wgust", example = "23.0")
    @JsonProperty("wgust")
    private Object wgust;
    @ApiModelProperty(notes = "windchill", example = "44.8")
    @JsonProperty("windchill")
    private Object windchill;
}
