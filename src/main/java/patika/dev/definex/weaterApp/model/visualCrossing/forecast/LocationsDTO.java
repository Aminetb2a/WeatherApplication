package patika.dev.definex.weaterApp.model.visualCrossing.forecast;

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
public class LocationsDTO {
    @JsonProperty("stationContributions")
    private Object stationContributions;
    @JsonProperty("values")
    private List<ValuesDTO> values;
    @JsonProperty("id")
    private String id;
    @JsonProperty("address")
    private String address;
    @JsonProperty("name")
    private String name;
    @JsonProperty("index")
    private Integer index;
    @JsonProperty("latitude")
    private Double latitude;
    @JsonProperty("longitude")
    private Double longitude;
    @JsonProperty("distance")
    private Double distance;
    @JsonProperty("time")
    private Double time;
    @JsonProperty("tz")
    private String tz;
    @JsonProperty("currentConditions")
    private CurrentConditionsDTO currentConditions;
    @JsonProperty("alerts")
    private Object alerts;
}
