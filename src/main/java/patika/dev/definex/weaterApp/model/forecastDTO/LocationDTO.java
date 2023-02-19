package patika.dev.definex.weaterApp.model.forecastDTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"id", "address", "name", "tz", "index", "latitude", "longitude", "distance", "time", "tz", "alerts", "stationContributions", "currentConditions", "values"})
public class LocationDTO {
    @JsonProperty("stationContributions")
    private Object stationContributions;
    @ApiModelProperty(notes = "id", example = "london")
    @JsonProperty("id")
    private String id;
    @ApiModelProperty(notes = "address", example = "London, England, United Kingdom")
    @JsonProperty("address")
    private String address;
    @ApiModelProperty(notes = "name", example = "london")
    @JsonProperty("name")
    private String name;
    @ApiModelProperty(notes = "index", example = "0")
    @JsonProperty("index")
    private Integer index;
    @ApiModelProperty(notes = "latitude", example = "51.5064")
    @JsonProperty("latitude")
    private Double latitude;
    @ApiModelProperty(notes = "longitude", example = "-0.12721")
    @JsonProperty("longitude")
    private Double longitude;
    @ApiModelProperty(notes = "distance", example = "0.0")
    @JsonProperty("distance")
    private Double distance;
    @ApiModelProperty(notes = "time", example = "0.0")
    @JsonProperty("time")
    private Double time;
    @ApiModelProperty(notes = "tz", example = "Europe/London")
    @JsonProperty("tz")
    private String tz;
    @JsonProperty("currentConditions")
    private CurrentConditionsDTO currentConditions;
    @JsonProperty("alerts")
    private Object alerts;
    @JsonProperty("values")
    private List<ValuesDTO> values;
}
