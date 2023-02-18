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
    public ResponseEntity<?> getWeatherForecast(String location, Integer forecastDays, Integer timesteps) {
        params = getParams();
        params.add(LOCATIONS, location);
        params.add(FORECASTDAYS, forecastDays.toString());
        params.add(AGGREGATEHOURS, timesteps.toString());
        ResponseEntity<?> response = get(FORECAST, params);
        if (response.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.ok(objectMapper.readValue(response.getBody().toString(), WeatherBaseResponse.class));
        }
        return response;
    }

    @SneakyThrows
    public ResponseEntity<?> getHistoricalWeather(String location, Period period, Integer timestepsHours, Integer timestepsMinutes, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        params = getParams();
        if (startDateTime == null & period == null)
            period = Period.today;
        params.add(PERIOD, period.name());
        params.add(LOCATIONS, location);
        Optional.ofNullable(endDateTime).ifPresent(d -> params.add(ENDDATETIME, d.toString()));
        Optional.ofNullable(startDateTime).ifPresent(d -> params.add(STARTDATETIME, d.toString()));
        Optional.ofNullable(timestepsHours).ifPresent(t -> params.add(AGGREGATEHOURS, t.toString()));
        Optional.ofNullable(timestepsMinutes).ifPresent(t -> params.add(AGGREGATEMINUTES, t.toString()));
        ResponseEntity<?> response = get(HISTORY, params);
        if (response.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.ok(objectMapper.readValue(response.getBody().toString(), WeatherBaseResponse.class));
        }
        return response;
    }

    @SneakyThrows
    public ResponseEntity<?> getWeatherHistorySummary(String location, ChronoUnit chronoUnit, BreakBy breakBy, Integer timestepsHours, Integer maxYear, Integer minYear) {
        params = getParams();
        params.add(LOCATIONS, location);
        params.add(BREAKBY, breakBy.name());
        params.add(MINYEAR, minYear.toString());
        params.add(MAXYEAR, maxYear.toString());
        params.add(CHRONOUNIT, chronoUnit.name());
        params.add(AGGREGATEHOURS, timestepsHours.toString());
        return get(HISTORY_SUMMARY, params);
    }

    private MultiValueMap<String, String> getParams() {
        return new LinkedMultiValueMap<>() {{
            add(CONTENTTYPE, JSON);
            add(LOCATIONMODE, ARRAY);
            add(SHORTCOLUMNNAMES, TRUE);
        }};
    }
}
