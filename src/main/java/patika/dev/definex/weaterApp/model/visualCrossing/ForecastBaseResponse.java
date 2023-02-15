package patika.dev.definex.weaterApp.model.visualCrossing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import patika.dev.definex.weaterApp.model.visualCrossing.forecast.LocationsDTO;

import java.util.List;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastBaseResponse {
    @JsonProperty("messages")
    private Object messages;
    @JsonProperty("locations")
    private List<LocationsDTO> locations;

}
