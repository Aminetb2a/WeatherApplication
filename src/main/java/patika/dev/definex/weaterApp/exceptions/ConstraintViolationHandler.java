package patika.dev.definex.weaterApp.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import patika.dev.definex.weaterApp.validator.model.ValidationError;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@Slf4j
@RestControllerAdvice
public class ConstraintViolationHandler {

    /**
     * Constraint violation exception handler
     *
     * @param ex ConstraintViolationException
     * @return List<ValidationError> - list of ValidationError built
     * from set of ConstraintViolation
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public List<ValidationError> handleConstraintViolation(ConstraintViolationException ex) {
        return buildValidationErrors(ex.getConstraintViolations());
    }

    /**
     * Build list of ValidationError from set of ConstraintViolation
     *
     * @param violations Set<ConstraintViolation<?>> - Set
     *                   of parameterized ConstraintViolations
     * @return List<ValidationError> - list of validation errors
     */
    private List<ValidationError> buildValidationErrors(Set<ConstraintViolation<?>> violations) {
        return violations.
                stream().
                map(violation ->
                        ValidationError.builder()
                                .field(
                                        StreamSupport.stream(
                                                        violation.getPropertyPath().spliterator(), false).
                                                reduce((first, second) -> second).
                                                orElse(null).
                                                toString()
                                )
                                .message(violation.getMessage())
                                .build()).
                collect(toList());
    }
}
