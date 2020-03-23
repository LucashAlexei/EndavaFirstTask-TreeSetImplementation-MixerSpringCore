package myvalidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IDFormat implements ConstraintValidator<CheckIDFormat, String> {

    @Override
    public void initialize(CheckIDFormat constraintAnnotation) {
    }

    @Override
    public boolean isValid(String id, ConstraintValidatorContext cvc) {
        return (id != null) &&
                (id.toCharArray().length >= 4) && (id.toCharArray().length <= 10)
                && (id.matches("[0-9]+"));
    }
}
