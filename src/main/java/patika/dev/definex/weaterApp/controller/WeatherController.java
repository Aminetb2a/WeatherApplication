package patika.dev.definex.weaterApp.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import patika.dev.definex.weaterApp.enums.BreakBy;
import patika.dev.definex.weaterApp.enums.ChronoUnit;
import patika.dev.definex.weaterApp.enums.Period;
import patika.dev.definex.weaterApp.model.WeatherBaseResponse;
import patika.dev.definex.weaterApp.service.WeatherService;
import patika.dev.definex.weaterApp.validator.model.ValidationError;
import patika.dev.definex.weaterApp.validator.timesteps.TimeSteps;

import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static patika.dev.definex.weaterApp.config.constants.Constants.Path.*;

@Slf4j
@Validated
@RestController
@Api(WEATHER_API)
@RequestMapping(WEATHER)
@RequiredArgsConstructor
public class WeatherController {

    private final static int year = LocalDate.now().getYear();
    private final WeatherService mWeatherService;


    @Operation(summary = "Get Weather Forecast", description = "Provides access to up to 15-days of weather forecast information", tags = {"Forecast"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = WeatherBaseResponse.class)))),
            @ApiResponse(responseCode = "400", description = "Bad Request")})
    @GetMapping(FORECAST)
    public ResponseEntity<?> getWeatherForecast(@RequestParam @Size(min = 2, message = "Location must be provided") @ApiParam(name = "location", value = "Location", example = "london") String location,
                                                @RequestParam(defaultValue = "5") @Positive @ApiParam(name = "forecastDays", value = "Forecast Days", example = "5") Integer forecastDays,
                                                @TimeSteps(Values = {1, 12, 24}, message = "The Integer value is invalid, supported values are 1, 12 or 24.") @ApiParam(name = "timesteps", value = "Forecast time steps", example = "12") Integer timesteps
    ) {
        return mWeatherService.getWeatherForecast(location, forecastDays, timesteps);
    }

    @Operation(summary = "Get Historical Weather Records", description = "Provides access to hourly and daily historical weather records", tags = {"History"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = WeatherBaseResponse.class)))),
            @ApiResponse(responseCode = "400", description = "Bad Request")})
    @GetMapping(HISTORY)
    public ResponseEntity<?> getHistoricalWeather(
            Period period,
            @Positive Integer timestepsMinutes,
            @RequestParam @Size(min = 2, message = "Location must be provided") String location,
            @PastOrPresent @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDateTime,
            @PastOrPresent @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDateTime,
            @TimeSteps(Values = {1, 24}, message = "The Integer value is invalid, supported values are 1 or 24.") Integer timestepsHours
    ) {
        return mWeatherService.getHistoricalWeather(location, period, timestepsHours, timestepsMinutes, startDateTime, endDateTime);
    }

    @Operation(summary = "Get Historical Weather Reports", description = "Provides access to historical weather reports and processed information", tags = {"Reports"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = WeatherBaseResponse.class)))),
            @ApiResponse(responseCode = "400", description = "Bad Request")})
    @GetMapping(SUMMARY)
    public ResponseEntity<?> getHistoricalWeather(
            @RequestParam @Min(1970) Integer maxYear,
            @RequestParam @Min(1970) Integer minYear,
            @RequestParam(defaultValue = "none") BreakBy breakBy,
            @RequestParam(defaultValue = "weeks") ChronoUnit chronoUnit,
            @RequestParam @Size(min = 2, message = "Location must be provided") String location,
            @TimeSteps(Values = {1, 24}, message = "The Integer value is invalid, supported values are 1 or 24.") Integer timestepsHours
    ) {
        if (minYear > maxYear || maxYear > year) {
            return ResponseEntity.badRequest().body(
                    ValidationError.builder()
                            .field("maxYear")
                            .message("maxYear must be between the minYear and the current calendar year inclusive")
                            .build()
            );
        }
        return mWeatherService.getWeatherHistorySummary(location, chronoUnit, breakBy, timestepsHours, maxYear, minYear);
    }
}
