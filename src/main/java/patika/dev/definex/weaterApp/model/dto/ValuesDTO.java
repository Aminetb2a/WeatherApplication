package patika.dev.definex.weaterApp.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ValuesDTO {
    @Schema(description = "winddir – direction from which the wind is blowing",
            required = true)
    @JsonProperty("wdir")
    private Double wdir;
    @Schema(description = "uvindex is a value between 0 and 10 indicating the level of ultra violet (UV) exposure for that hour or day. 10 represents high level of exposure, and 0 represents no exposure",
            required = true)
    @JsonProperty("uvindex")
    private Double uvindex;
    @JsonProperty("datetimeStr")
    private String datetimeStr;
    @Schema(description = "preciptype an array indicating the type(s) of precipitation expected or that occurred. Possible values include rain, snow, freezingrain and ice.",
            required = true)
    @JsonProperty("preciptype")
    private String preciptype;
    @Schema(description = "cin (forecast only) convective inhibition. A number representing the level of atmospheric tendency to prevent instability and therefore prevent thunderstorms.",
            required = true)
    @JsonProperty("cin")
    private Double cin;
    @Schema(description = "cloudcover – how much of the sky is covered in cloud ranging from 0-100%",
            required = true)
    @JsonProperty("cloudcover")
    private Double cloudcover;
    @JsonProperty("pop")
    private Double pop;
    @Schema(description = "datetime – ISO 8601 formatted date, time or datetime value indicating the date and time of the weather data in the local time zone of the requested location. See Dates and Times in the Weather API for more information.",
            required = true)
    @JsonProperty("datetime")
    private Long datetime;
    @Schema(description = "precip – the amount of liquid precipitation that fell or is predicted to fall in the period. This includes the liquid-equivalent amount of any frozen precipitation such as snow or ice.",
            required = true)
    @JsonProperty("precip")
    private Double precip;
    @Schema(description = " (W/m2) the solar radiation power at the instantaneous moment of the observation (or forecast prediction).",
            required = true)
    @JsonProperty("solarradiation")
    private Double solarradiation;
    @Schema(description = "dew – dew point temperature",
            required = true)
    @JsonProperty("dew")
    private Double dew;
    @Schema(description = "humidity – relative humidity in %",
            required = true)
    @JsonProperty("humidity")
    private Double humidity;
    @Schema(description = "temp – temperature at the location. Daily values are average values (mean) for the day.",
            required = true)
    @JsonProperty("temp")
    private Double temp;
    @Schema(description = "visibility – distance at which distant objects are visible",
            required = true)
    @JsonProperty("visibility")
    private Double visibility;
    @Schema(description = "windspeed – the sustained wind speed measured as the average windspeed that occurs during the preceding one to two minutes. Daily values are the maximum hourly value for the day.",
            required = true)
    @JsonProperty("wspd")
    private Double wspd;
    @Schema(description = "severerisk (forecast only) – a value between 0 and 100 representing the risk of convective storms (eg thunderstorms, hail and tornadoes).",
            required = true)
    @JsonProperty("severerisk")
    private Double severerisk;
    @Schema(description = "solarenergy – (MJ /m2 ) indicates the total energy from the sun that builds up over an hour or day.",
            required = true)
    @JsonProperty("solarenergy")
    private Double solarenergy;
    @JsonProperty("heatindex")
    private Object heatindex;
    @Schema(description = "snowdepth – the depth of snow on the ground",
            required = true)
    @JsonProperty("snowdepth")
    private Double snowdepth;
    @JsonProperty("sealevelpressure")
    private Double sealevelpressure;
    @Schema(description = "snow – the amount of snow that fell or is predicted to fall",
            required = true)
    @JsonProperty("snow")
    private Double snow;
    @Schema(description = "windgust – instantaneous wind speed at a location – May be empty if it is not significantly higher than the wind speed. Daily values are the maximum hourly value for the day.",
            required = true)
    @JsonProperty("wgust")
    private Double wgust;
    @Schema(description = "conditions – textual representation of the weather conditions. ",
            required = true)
    @JsonProperty("conditions")
    private String conditions;
    @JsonProperty("windchill")
    private Object windchill;
    @Schema(description = "cape (forecast only) – convective available potential energy. This is a numbering indicating amount of energy available to produce thunderstorms. A higher values indicates a more unstable atmosphere capable of creating stronger storms. Values lower than 1000 J/kg indicate generally low instability, between 1000-2500 J/kg medium instability and 2500-4000 J/kg high instability. Values greater than 4000 J/kg indicating an extremely unstable atmosphere.",
            required = true)
    @JsonProperty("cape")
    private Double cape;
}
