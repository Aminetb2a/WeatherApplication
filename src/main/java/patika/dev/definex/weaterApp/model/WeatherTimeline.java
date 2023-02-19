package patika.dev.definex.weaterApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import patika.dev.definex.weaterApp.model.timelineDTO.DaysDTO;
import patika.dev.definex.weaterApp.model.timelineDTO.StationDTO;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherTimeline {
    @JsonProperty("queryCost")
    private Integer queryCost;
    @JsonProperty("latitude")
    private Double latitude;
    @JsonProperty("longitude")
    private Double longitude;
    @JsonProperty("resolvedAddress")
    private String resolvedAddress;
    @JsonProperty("address")
    private String address;
    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("tzoffset")
    private Double tzoffset;
    @JsonProperty("days")
    private List<DaysDTO> days;
    @JsonProperty("stations")
    private Map<String, StationDTO> stations = new LinkedHashMap<>();

}
