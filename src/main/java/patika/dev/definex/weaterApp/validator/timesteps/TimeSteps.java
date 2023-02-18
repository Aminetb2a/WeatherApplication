package patika.dev.definex.weaterApp.validator.timesteps;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = OneOfIntegersValidator.class)
public @interface TimeSteps {

    int[] Values();

    //error message
    public String message() default "The Integer value is invalid.";

    //represents group of constraints
    public Class<?>[] groups() default {};

    //represents additional information about annotation
    public Class<? extends Payload>[] payload() default {};
}
