package patika.dev.definex.weaterApp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
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


@Service
public class WeatherService extends BaseService {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

    protected WeatherService(RestTemplate mRestTemplate, WeatherConfigurationProperties mWeatherConfigurationProperties) {
        super(mRestTemplate, mWeatherConfigurationProperties);
    }

    /**
     * Method to Get the weather forecast for a location, for a number of days, with a number of timesteps per
     * day
     *
     * @param location     The location you want to get the weather forecast for.
     * @param forecastDays The number of days to forecast.
     * @param timesteps    The number of timesteps to aggregate the data into.
     * @return A LocationDTO object
     */
    @SneakyThrows
    public LocationDTO getWeatherForecast(String location, Integer forecastDays, Integer timesteps) {
        params = getParams();
        params.add(LOCATIONS, location);
        params.add(FORECASTDAYS, forecastDays.toString());
        params.add(AGGREGATEHOURS, timesteps.toString());
        ResponseEntity<?> response = get(WEATHER_DATA + SLASH + FORECAST, params);
        return objectMapper.readValue(response.getBody().toString(), WeatherBaseResponse.class).getLocation();
    }

    /**
     * Method to Get historical weather data for a location.
     *
     * @param location         The location you want to get the weather for.
     * @param period           The period of time for which you want to get the weather data.
     * @param timestepsHours   The number of hours to aggregate the data into.
     * @param timestepsMinutes The number of minutes between each timestep.
     * @param startDateTime    The start date and time of the period you want to get historical weather
     *                         data for.
     * @param endDateTime      The end date and time of the period for which you want to retrieve weather
     *                         data.
     * @return A LocationDTO object
     */
    @SneakyThrows
    public LocationDTO getHistoricalWeather(String location, Period period, Integer timestepsHours, Integer timestepsMinutes, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        params = getParams();
        if (startDateTime == null && period == null)
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

    /**
     * This method returns a summary of the weather history for a given location, broken down by the
     * specified chronoUnit, breakBy, timestepsHours, maxYear, and minYear
     *
     * @param location       The location you want to get the weather data for.
     * @param chronoUnit     The time unit to break the data by.
     * @param breakBy        The time unit to break the data by.
     * @param timestepsHours The number of hours to aggregate the data by.
     * @param maxYear        The maximum year to include in the query.
     * @param minYear        The minimum year to include in the results.
     * @return A JSON object containing the weather data for the specified location.
     */
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

    /**
     * Method to Get the weather timeline for a location between two dates.
     *
     * @param location The location you want to get the weather for.
     * @param date1    The start date of the timeline.
     * @param date2    The end date of the timeline.
     * @return A WeatherTimeline object
     */
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

    /**
     * If the startDate is after the endDate, return a 400 response with a ValidationError that
     * describes the error.
     *
     * @param startDate The start date of the period
     * @param endDate   The end date of the period
     * @return A ResponseEntity with a status of 400 (bad request) and a body of a ValidationError
     * object.
     */
    public ResponseEntity<ValidationError> dateValidator(LocalDate startDate, LocalDate endDate) {
        return ResponseEntity.badRequest().body(
                ValidationError.builder()
                        .field("endDate")
                        .message(String.format("The startDate %s must be before the endDate %s", startDate, endDate))
                        .build()
        );
    }
}
