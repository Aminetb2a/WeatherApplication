package patika.dev.definex.weaterApp.validator.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.List;

// Simple model class which represents our DefaultErrorAttributes.
// The alternative would be to use DefaultErrorAttributes and set the
// error code etc. in the request
@Builder
@Getter
@JsonPropertyOrder({"timestamp", "status", "field", "error", "errors", "message"})
@JsonAutoDetect(isGetterVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY, fieldVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ValidationError {
    final int status;
    final String error;
    final String field;
    final String message;
    final List<String> errors;
    final Instant timestamp = Instant.now();

    public int getStatus() {
        return HttpStatus.BAD_REQUEST.value();
    }

    public String getError() {
        return HttpStatus.BAD_REQUEST.getReasonPhrase();
    }
}
