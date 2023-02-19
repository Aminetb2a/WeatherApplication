package patika.dev.definex.weaterApp.config.constants;

public interface Constants {

    interface Path {
        String SLASH = "/";
        String HISTORY = "history";
        String SUMMARY = "summary";
        String WEATHER = "weather";
        String FORECAST = "forecast";
        String TIMELINE = "timeline";
        String WEATHER_DATA = "weatherdata";
        String WEATHER_API = "WEATHER API";
        String HISTORY_SUMMARY = "historysummary";
    }

    interface Key {
        String PERIOD = "period";
        String BREAKBY = "breakBy";
        String MINYEAR = "minYear";
        String MAXYEAR = "maxYear";
        String LOCATIONS = "locations";
        String CHRONOUNIT = "chronoUnit";
        String CONTENTTYPE = "contentType";
        String ENDDATETIME = "endDateTime";
        String FORECASTDAYS = "forecastDays";
        String LOCATIONMODE = "locationMode";
        String STARTDATETIME = "startDateTime";
        String AGGREGATEHOURS = "aggregateHours";
        String SHORTCOLUMNNAMES = "shortColumnNames";
        String AGGREGATEMINUTES = "aggregateMinutes";
    }

    interface Value {
        String JSON = "json";
        String SINGLE = "single";
        String TRUE = "true";
    }
}
