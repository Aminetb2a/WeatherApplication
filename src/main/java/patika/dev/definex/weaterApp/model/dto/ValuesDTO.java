package patika.dev.definex.weaterApp.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ValuesDTO {
    @ApiModelProperty(notes = "winddir", example = "252.0")
    @Schema(description = "winddir – direction from which the wind is blowing")
    @JsonProperty("wdir")
    private Double wdir;
    @ApiModelProperty(notes = "uvindex", example = "0.0")
    @Schema(description = "uvindex is a value between 0 and 10 indicating the level of ultra violet (UV) exposure for that hour or day. 10 represents high level of exposure, and 0 represents no exposure")
    @JsonProperty("uvindex")
    private Double uvindex;
    @ApiModelProperty(notes = "datetimeStr", example = "2023-02-18T00:00:00Z")
    @JsonProperty("datetimeStr")
    private String datetimeStr;
    @Schema(description = "preciptype an array indicating the type(s) of precipitation expected or that occurred. Possible values include rain, snow, freezingrain and ice.")
    @JsonProperty("preciptype")
    private String preciptype;
    @ApiModelProperty(notes = "cin", example = "-0.5")
    @Schema(description = "cin (forecast only) convective inhibition. A number representing the level of atmospheric tendency to prevent instability and therefore prevent thunderstorms.")
    @JsonProperty("cin")
    private Double cin;
    @ApiModelProperty(notes = "cloudcover", example = "54.7")
    @Schema(description = "cloudcover – how much of the sky is covered in cloud ranging from 0-100%")
    @JsonProperty("cloudcover")
    private Double cloudcover;
    @ApiModelProperty(notes = "pop", example = "0.0")
    @JsonProperty("pop")
    private Double pop;
    @ApiModelProperty(notes = "datetime", example = "1676678400000")
    @Schema(description = "datetime – ISO 8601 formatted date, time or datetime value indicating the date and time of the weather data in the local time zone of the requested location. See Dates and Times in the Weather API for more information.")
    @JsonProperty("datetime")
    private Long datetime;
    @ApiModelProperty(notes = "precip", example = "0.0")
    @Schema(description = "precip – the amount of liquid precipitation that fell or is predicted to fall in the period. This includes the liquid-equivalent amount of any frozen precipitation such as snow or ice.")
    @JsonProperty("precip")
    private Double precip;
    @ApiModelProperty(notes = "solarradiation", example = "0.0")
    @Schema(description = " (W/m2) the solar radiation power at the instantaneous moment of the observation (or forecast prediction).")
    @JsonProperty("solarradiation")
    private Double solarradiation;
    @ApiModelProperty(notes = "dew", example = "45.1")
    @Schema(description = "dew – dew point temperature")
    @JsonProperty("dew")
    private Double dew;
    @ApiModelProperty(notes = "humidity", example = "87.3")
    @Schema(description = "humidity – relative humidity in %")
    @JsonProperty("humidity")
    private Double humidity;
    @ApiModelProperty(notes = "temp", example = "48.7")
    @Schema(description = "temp – temperature at the location. Daily values are average values (mean) for the day.")
    @JsonProperty("temp")
    private Double temp;
    @ApiModelProperty(notes = "visibility", example = "15.0")
    @Schema(description = "visibility – distance at which distant objects are visible")
    @JsonProperty("visibility")
    private Double visibility;
    @ApiModelProperty(notes = "wspd", example = "8.9")
    @Schema(description = "windspeed – the sustained wind speed measured as the average windspeed that occurs during the preceding one to two minutes. Daily values are the maximum hourly value for the day.")
    @JsonProperty("wspd")
    private Double wspd;
    @ApiModelProperty(notes = "severerisk", example = "10.0")
    @Schema(description = "severerisk (forecast only) – a value between 0 and 100 representing the risk of convective storms (eg thunderstorms, hail and tornadoes).")
    @JsonProperty("severerisk")
    private Double severerisk;
    @ApiModelProperty(notes = "solarenergy", example = "0.0")
    @Schema(description = "solarenergy – (MJ /m2 ) indicates the total energy from the sun that builds up over an hour or day.")
    @JsonProperty("solarenergy")
    private Double solarenergy;
    @JsonProperty("heatindex")
    private Object heatindex;
    @ApiModelProperty(notes = "snowdepth", example = "0.0")
    @Schema(description = "snowdepth – the depth of snow on the ground")
    @JsonProperty("snowdepth")
    private Double snowdepth;
    @ApiModelProperty(notes = "sealevelpressure", example = "1022.0")
    @JsonProperty("sealevelpressure")
    private Double sealevelpressure;
    @ApiModelProperty(notes = "snow", example = "0.0")
    @Schema(description = "snow – the amount of snow that fell or is predicted to fall")
    @JsonProperty("snow")
    private Double snow;
    @ApiModelProperty(notes = "wgust", example = "23.0")
    @Schema(description = "windgust – instantaneous wind speed at a location – May be empty if it is not significantly higher than the wind speed. Daily values are the maximum hourly value for the day.")
    @JsonProperty("wgust")
    private Double wgust;
    @ApiModelProperty(notes = "conditions", example = "Partially cloudy")
    @Schema(description = "conditions – textual representation of the weather conditions. ")
    @JsonProperty("conditions")
    private String conditions;
    @ApiModelProperty(notes = "windchill", example = "44.8")
    @JsonProperty("windchill")
    private Object windchill;
    @ApiModelProperty(notes = "cape", example = "1.0")
    @Schema(description = "cape (forecast only) – convective available potential energy. This is a numbering indicating amount of energy available to produce thunderstorms. A higher values indicates a more unstable atmosphere capable of creating stronger storms. Values lower than 1000 J/kg indicate generally low instability, between 1000-2500 J/kg medium instability and 2500-4000 J/kg high instability. Values greater than 4000 J/kg indicating an extremely unstable atmosphere.")
    @JsonProperty("cape")
    private Double cape;
}
