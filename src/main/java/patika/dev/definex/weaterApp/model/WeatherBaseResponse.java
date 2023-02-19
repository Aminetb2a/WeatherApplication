package patika.dev.definex.weaterApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import patika.dev.definex.weaterApp.model.forecastDTO.LocationDTO;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherBaseResponse {

    @JsonProperty("messages")
    private Object messages;
    @Schema(description = "Location is the address, partial address or latitude,longitude location for which to retrieve weather data.",
            example = "london", required = true)
    @ApiModelProperty(notes = "Location", example = "london", required = true)
    @JsonProperty("location")
    private LocationDTO location;

}
