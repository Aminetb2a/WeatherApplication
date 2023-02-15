package patika.dev.definex.weaterApp.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;


@Component
public class LoggingInterceptor implements ClientHttpRequestInterceptor {
    private static final Logger log = LoggerFactory.getLogger(LoggingInterceptor.class.getName());


    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        logRequest(request, body);
        ClientHttpResponse response = execution.execute(request, body);
        logResponse(response);
        return response;
    }

    private void logRequest(HttpRequest request, byte[] body) throws IOException {
        log.info("====================================request begin====================================");
        log.info("URI       : {}", request.getURI());
        if (log.isDebugEnabled()) {
            log.debug("Method       : {}", request.getMethod());
            log.debug("Headers       : {}", request.getHeaders());
            log.debug("Payload       : {}", new String(body, StandardCharsets.UTF_8));
        }
        log.info("====================================request end====================================");
    }

    private void logResponse(ClientHttpResponse response) throws IOException {
        log.info("====================================response begin====================================");
        log.info("Status Code       : {}", response.getStatusCode());
        if (log.isDebugEnabled()) {
            log.debug("Status       : {}", response.getStatusText());
            log.debug("Headers       : {}", response.getHeaders());
            log.debug("Response       : {}", StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()));
        }
        log.info("====================================response end====================================");
    }
}
