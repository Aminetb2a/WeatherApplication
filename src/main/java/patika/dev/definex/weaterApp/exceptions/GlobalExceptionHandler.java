package patika.dev.definex.weaterApp.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import patika.dev.definex.weaterApp.validator.model.ValidationError;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * If the request is missing a parameter, return a 400 response with a ValidationError object that
     * contains the missing parameter name and the error message
     *
     * @param ex      The exception that was thrown
     * @param headers HttpHeaders
     * @param status  The HTTP status code to return.
     * @param request The current request.
     * @return A ResponseEntity with a bad request status and a ValidationError object.
     */
    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseEntity.badRequest().body(
                ValidationError.builder()
                        .field(ex.getParameterName())
                        .message(ex.getMessage())
                        .build());
    }

    /**
     * If the request is not in the expected format, return a 400 Bad Request response with a
     * ValidationError object in the body
     *
     * @param ex      The exception that was thrown
     * @param headers HttpHeaders
     * @param status  The status code to return.
     * @param request The current request.
     * @return A ResponseEntity with a bad request status and a ValidationError object.
     */
    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseEntity.badRequest().body(
                ValidationError.builder()
                        .field(ex.getPropertyName())
                        .message(ex.getMessage())
                        .build());
    }

    /**
     * The MethodArgumentNotValidException handler, return a 400 Bad Request response with a
     * ValidationError object in the body
     *
     * @param ex      The exception that was thrown
     * @param headers HttpHeaders
     * @param status  The HTTP status code to return.
     * @param request The request that triggered the exception
     * @return A list of validation errors.
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<ValidationError> validationErrors = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(violation ->
                        ValidationError.builder()
                                .field(violation.getField())
                                .message(violation.getDefaultMessage())
                                .build()).
                collect(toList());

        return new ResponseEntity<>(validationErrors, status);
    }

}
