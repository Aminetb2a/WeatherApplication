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
public class HoursDTO {
    @JsonProperty("datetime")
    private String datetime;
    @JsonProperty("datetimeEpoch")
    private Integer datetimeEpoch;
    @JsonProperty("temp")
    private Double temp;
    @JsonProperty("feelslike")
    private Double feelslike;
    @JsonProperty("humidity")
    private Double humidity;
    @JsonProperty("dew")
    private Double dew;
    @JsonProperty("precip")
    private Double precip;
    @JsonProperty("precipprob")
    private Double precipprob;
    @JsonProperty("snow")
    private Double snow;
    @JsonProperty("snowdepth")
    private Double snowdepth;
    @JsonProperty("preciptype")
    private Object preciptype;
    @JsonProperty("windgust")
    private Double windgust;
    @JsonProperty("windspeed")
    private Double windspeed;
    @JsonProperty("winddir")
    private Double winddir;
    @JsonProperty("pressure")
    private Double pressure;
    @JsonProperty("visibility")
    private Double visibility;
    @JsonProperty("cloudcover")
    private Double cloudcover;
    @JsonProperty("solarradiation")
    private Object solarradiation;
    @JsonProperty("solarenergy")
    private Object solarenergy;
    @JsonProperty("uvindex")
    private Object uvindex;
    @JsonProperty("conditions")
    private String conditions;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("stations")
    private List<String> stations;
    @JsonProperty("source")
    private String source;
}
