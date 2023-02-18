package patika.dev.definex.weaterApp.validator.timesteps;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.stream.IntStream;

public class OneOfIntegersValidator implements ConstraintValidator<TimeSteps, Integer> {
    Integer[] arrayOfValues;

    @Override
    public void initialize(TimeSteps constraintAnnotation) {
        int[] values = constraintAnnotation.Values();
        this.arrayOfValues = IntStream.of(values).boxed().toArray(Integer[]::new);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        arrayOfValues = new Integer[]{1, 12, 24};
        return Arrays.asList(this.arrayOfValues).contains(value);
    }

}
