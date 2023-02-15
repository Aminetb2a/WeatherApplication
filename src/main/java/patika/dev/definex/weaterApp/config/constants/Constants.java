package patika.dev.definex.weaterApp.config.constants;

public interface Constants {

    interface Path {
        String WEATHER = "weather";
        String HISTORY = "history";
        String FORECAST = "forecast";
        String HISTORY_SUMMARY = "historysummary";
        String SUMMARY = "summary";
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
        String ARRAY = "array";
        String TRUE = "true";
    }
}
