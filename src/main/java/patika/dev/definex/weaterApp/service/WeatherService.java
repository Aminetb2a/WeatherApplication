package patika.dev.definex.weaterApp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import patika.dev.definex.weaterApp.config.prop.WeatherConfigurationProperties;
import patika.dev.definex.weaterApp.enums.BreakBy;
import patika.dev.definex.weaterApp.enums.ChronoUnit;
import patika.dev.definex.weaterApp.enums.Period;
import patika.dev.definex.weaterApp.model.WeatherBaseResponse;
import patika.dev.definex.weaterApp.model.WeatherTimeline;
import patika.dev.definex.weaterApp.model.forecastDTO.LocationDTO;
import patika.dev.definex.weaterApp.validator.model.ValidationError;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import static patika.dev.definex.weaterApp.config.constants.Constants.Key.*;
import static patika.dev.definex.weaterApp.config.constants.Constants.Path.*;
import static patika.dev.definex.weaterApp.config.constants.Constants.Value.*;

@Slf4j
@Service
public class WeatherService extends BaseService {

    private final static ObjectMapper objectMapper = new ObjectMapper();
    private static MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

    protected WeatherService(RestTemplate mRestTemplate, WeatherConfigurationProperties mWeatherConfigurationProperties) {
        super(mRestTemplate, mWeatherConfigurationProperties);
    }

    @SneakyThrows
    public LocationDTO getWeatherForecast(String location, Integer forecastDays, Integer timesteps) {
        params = getParams();
        params.add(LOCATIONS, location);
        params.add(FORECASTDAYS, forecastDays.toString());
        params.add(AGGREGATEHOURS, timesteps.toString());
        ResponseEntity<?> response = get(WEATHER_DATA + SLASH + FORECAST, params);
        return objectMapper.readValue(response.getBody().toString(), WeatherBaseResponse.class).getLocation();
    }

    @SneakyThrows
    public LocationDTO getHistoricalWeather(String location, Period period, Integer timestepsHours, Integer timestepsMinutes, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        params = getParams();
        if (startDateTime == null & period == null)
            period = Period.today;
        params.add(PERIOD, period.name());
        params.add(LOCATIONS, location);
        Optional.ofNullable(endDateTime).ifPresent(d -> params.add(ENDDATETIME, d.toString()));
        Optional.ofNullable(startDateTime).ifPresent(d -> params.add(STARTDATETIME, d.toString()));
        Optional.ofNullable(timestepsHours).ifPresent(t -> params.add(AGGREGATEHOURS, t.toString()));
        Optional.ofNullable(timestepsMinutes).ifPresent(t -> params.add(AGGREGATEMINUTES, t.toString()));
        ResponseEntity<?> response = get(WEATHER_DATA + SLASH + HISTORY, params);
        return objectMapper.readValue(response.getBody().toString(), WeatherBaseResponse.class).getLocation();
    }

    public ResponseEntity<?> getWeatherHistorySummary(String location, ChronoUnit chronoUnit, BreakBy breakBy, Integer timestepsHours, Integer maxYear, Integer minYear) {
        params = getParams();
        params.add(LOCATIONS, location);
        params.add(BREAKBY, breakBy.name());
        params.add(MINYEAR, minYear.toString());
        params.add(MAXYEAR, maxYear.toString());
        params.add(CHRONOUNIT, chronoUnit.name());
        params.add(AGGREGATEHOURS, timestepsHours.toString());
        return get(WEATHER_DATA + SLASH + HISTORY_SUMMARY, params);
    }

    @SneakyThrows
    public ResponseEntity<?> getWeatherTimeline(String location, LocalDate date1, LocalDate date2) {
        params = new LinkedMultiValueMap<>();
        StringBuilder path = new StringBuilder();
        path.append(location);
        path.append(SLASH);
        Optional.ofNullable(date1).ifPresent(path::append);
        path.append(SLASH);
        Optional.ofNullable(date2).ifPresent(path::append);
        ResponseEntity<?> response = get(TIMELINE + SLASH + path, params);
        if (response.getStatusCode().is2xxSuccessful())
            return ResponseEntity.ok(objectMapper.readValue(response.getBody().toString(), WeatherTimeline.class));
        return response;
    }

    private MultiValueMap<String, String> getParams() {
        return new LinkedMultiValueMap<>() {{
            add(CONTENTTYPE, JSON);
            add(LOCATIONMODE, SINGLE);
            add(SHORTCOLUMNNAMES, TRUE);
        }};
    }

    public ResponseEntity<ValidationError> dateValidator(LocalDate startDate, LocalDate endDate) {
        return ResponseEntity.badRequest().body(
                ValidationError.builder()
                        .field("endDate")
                        .message(String.format("The startDate %s cannot be before the endDate %s", startDate, endDate))
                        .build()
        );
    }
}
