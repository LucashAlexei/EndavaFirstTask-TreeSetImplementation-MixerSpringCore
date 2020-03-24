package myvalidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IDFormat implements ConstraintValidator<CheckIDFormat, String> {
    private int max;
    private int min;

    @Override
    public void initialize(CheckIDFormat constraintAnnotation) {
        max = constraintAnnotation.max();
        min = constraintAnnotation.min();
    }

    @Override
    public boolean isValid(String id, ConstraintValidatorContext cvc) {

        return  (id!=null) &&
                (id.toCharArray().length >= 4) && (id.toCharArray().length <= 10)
                && (id.matches("[0-9]+"));
    }
}
