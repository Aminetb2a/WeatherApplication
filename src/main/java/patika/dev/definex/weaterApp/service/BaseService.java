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

    /**
     * This method makes a GET request to the given path with the given parameters and returns the
     * response as a String.
     *
     * @param path   The path of the endpoint you want to hit.
     * @param params The parameters to be sent to the server.
     * @return A ResponseEntity object.
     */
    public ResponseEntity<?> get(String path, MultiValueMap<String, String> params) {
        return exchange(HttpMethod.GET, path, params, new ParameterizedTypeReference<String>() {
        });
    }

    /**
     * Base method to send http request after setting url, path, parameters, and API key
     *
     * @param method     The HTTP method to use.
     * @param path       The path of the API endpoint.
     * @param params     The parameters to be sent to the API.
     * @param returnType The type of the response body.
     * @return ResponseEntity<?>
     */
    public ResponseEntity<?> exchange(HttpMethod method, String path, MultiValueMap<String, String> params, ParameterizedTypeReference<?> returnType) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(mWeatherConfigurationProperties.getUrl()).path(path);
        params.add("key", mWeatherConfigurationProperties.getApiKey());
        builder.queryParams(params);
        RequestEntity.BodyBuilder requestBuilder = RequestEntity.method(method, builder.build().toUri());
        requestBuilder.contentType(MediaType.APPLICATION_JSON);
        RequestEntity<Object> requestEntity = requestBuilder.body(null);
        try {
            return getRestTemplate().exchange(requestEntity, returnType);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public RestTemplate getRestTemplate() {
        return mRestTemplate;
    }
}
