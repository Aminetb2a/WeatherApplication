package patika.dev.definex.weaterApp.config.prop;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "weather")
public class WeatherConfigurationProperties {
    private String url;
    private String apiKey;
}
