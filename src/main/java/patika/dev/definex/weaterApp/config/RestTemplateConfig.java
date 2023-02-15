package patika.dev.definex.weaterApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;
import patika.dev.definex.weaterApp.logging.LoggingInterceptor;

import java.util.List;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(LoggingInterceptor loggingInterceptor) {
        RestTemplate restTemplate = new RestTemplate();
        List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
        interceptors.add(loggingInterceptor);
        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }
}
