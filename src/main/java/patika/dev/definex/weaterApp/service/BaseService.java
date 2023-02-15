package patika.dev.definex.weaterApp.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import patika.dev.definex.weaterApp.config.prop.WeatherConfigurationProperties;


public abstract class BaseService {

    private final RestTemplate mRestTemplate;
    private final WeatherConfigurationProperties mWeatherConfigurationProperties;

    protected BaseService(RestTemplate mRestTemplate, WeatherConfigurationProperties mWeatherConfigurationProperties) {
        this.mRestTemplate = mRestTemplate;
        this.mWeatherConfigurationProperties = mWeatherConfigurationProperties;
    }

    public ResponseEntity<?> get(String path, MultiValueMap<String, String> params) {
        return exchange(HttpMethod.GET, path, params, new ParameterizedTypeReference<String>() {
        });
    }

    public ResponseEntity<?> exchange(HttpMethod method, String path, MultiValueMap<String, String> params, ParameterizedTypeReference<?> returnType) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(mWeatherConfigurationProperties.getUrl()).path(path);
        params.add("key", mWeatherConfigurationProperties.getApiKey());
        builder.queryParams(params);
        RequestEntity.BodyBuilder requestBuilder = RequestEntity.method(method, builder.build().toUri());
        requestBuilder.contentType(MediaType.APPLICATION_JSON);
        RequestEntity<Object> requestEntity = requestBuilder.body(null);
        return getRestTemplate().exchange(requestEntity, returnType);
    }

    public RestTemplate getRestTemplate() {
        return mRestTemplate;
    }
}
