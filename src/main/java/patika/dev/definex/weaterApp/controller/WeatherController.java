package patika.dev.definex.weaterApp.controller;

import lombok.AllArgsConstructor;
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
import patika.dev.definex.weaterApp.service.WeatherService;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

import static patika.dev.definex.weaterApp.config.constants.Constants.Path.*;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping(WEATHER)
public class WeatherController {

    private final WeatherService mWeatherService;

    @GetMapping(FORECAST)
    public ResponseEntity<?> getWeatherForecast(@RequestParam @NotNull String location,
                                                @RequestParam(defaultValue = "5") @Positive Integer forecastDays,
                                                @Positive @Min(0) Integer timesteps
    ) {
        return mWeatherService.getWeatherForecast(location, forecastDays, timesteps);
    }

    @GetMapping(HISTORY)
    public ResponseEntity<?> getHistoricalWeather(
            Period period,
            @RequestParam @NotNull String location,
            @Positive @Min(0) Integer timestepsHours,
            @Positive @Min(0) Integer timestepsMinutes,
            @PastOrPresent @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDateTime,
            @PastOrPresent @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDateTime
    ) {
        return mWeatherService.getHistoricalWeather(location, period, timestepsHours, timestepsMinutes, startDateTime, endDateTime);
    }

    @GetMapping(SUMMARY)
    public ResponseEntity<?> getHistoricalWeather(
            @RequestParam @NotNull String location,
            @Positive @Min(0) Integer timestepsHours,
            @RequestParam @NotNull @Min(1970) Integer maxYear,
            @RequestParam @NotNull @Min(1970) Integer minYear,
            @RequestParam(defaultValue = "none") BreakBy breakBy,
            @RequestParam(defaultValue = "weeks") ChronoUnit chronoUnit
    ) {
        return mWeatherService.getWeatherHistorySummary(location, chronoUnit, breakBy, timestepsHours, maxYear, minYear);
    }
}
