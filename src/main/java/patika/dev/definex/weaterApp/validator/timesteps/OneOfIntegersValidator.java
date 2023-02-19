package patika.dev.definex.weaterApp.validator.timesteps;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.stream.IntStream;

public class OneOfIntegersValidator implements ConstraintValidator<TimeSteps, Integer> {
    Integer[] arrayOfValues;

    /**
     * "The initialize function takes in the annotation and stores the values in an array."
     * <p>
     * The first line of the function is the annotation. It tells the compiler that this function is
     * overriding a function in the superclass
     *
     * @param TimeSteps constraintAnnotation is the annotation that is being validated.
     */
    @Override
    public void initialize(TimeSteps constraintAnnotation) {
        int[] values = constraintAnnotation.Values();
        this.arrayOfValues = IntStream.of(values).boxed().toArray(Integer[]::new);
    }

    /**
     * If the value is in the array, return true, else return false.
     *
     * @param value   The value to be validated.
     * @param context The context in which the constraint is evaluated.
     * @return A boolean value.
     */
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        arrayOfValues = new Integer[]{1, 12, 24};
        return Arrays.asList(this.arrayOfValues).contains(value);
    }

}
