package patika.dev.definex.weaterApp.model.timelineDTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DaysDTO {
    @JsonProperty("datetime")
    private String datetime;
    @JsonProperty("datetimeEpoch")
    private Integer datetimeEpoch;
    @JsonProperty("tempmax")
    private Double tempmax;
    @JsonProperty("tempmin")
    private Double tempmin;
    @JsonProperty("temp")
    private Double temp;
    @JsonProperty("feelslikemax")
    private Double feelslikemax;
    @JsonProperty("feelslikemin")
    private Double feelslikemin;
    @JsonProperty("feelslike")
    private Double feelslike;
    @JsonProperty("dew")
    private Double dew;
    @JsonProperty("humidity")
    private Double humidity;
    @JsonProperty("precip")
    private Double precip;
    @JsonProperty("precipprob")
    private Double precipprob;
    @JsonProperty("precipcover")
    private Double precipcover;
    @JsonProperty("preciptype")
    private Object preciptype;
    @JsonProperty("snow")
    private Double snow;
    @JsonProperty("snowdepth")
    private Double snowdepth;
    @JsonProperty("windgust")
    private Double windgust;
    @JsonProperty("windspeed")
    private Double windspeed;
    @JsonProperty("winddir")
    private Double winddir;
    @JsonProperty("pressure")
    private Double pressure;
    @JsonProperty("cloudcover")
    private Double cloudcover;
    @JsonProperty("visibility")
    private Double visibility;
    @JsonProperty("solarradiation")
    private Object solarradiation;
    @JsonProperty("solarenergy")
    private Object solarenergy;
    @JsonProperty("uvindex")
    private Object uvindex;
    @JsonProperty("sunrise")
    private String sunrise;
    @JsonProperty("sunriseEpoch")
    private Integer sunriseEpoch;
    @JsonProperty("sunset")
    private String sunset;
    @JsonProperty("sunsetEpoch")
    private Integer sunsetEpoch;
    @JsonProperty("moonphase")
    private Double moonphase;
    @JsonProperty("conditions")
    private String conditions;
    @JsonProperty("description")
    private String description;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("stations")
    private List<String> stations;
    @JsonProperty("source")
    private String source;
    @JsonProperty("hours")
    private List<HoursDTO> hours;
}
