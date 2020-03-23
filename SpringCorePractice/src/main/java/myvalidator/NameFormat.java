package myvalidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameFormat implements ConstraintValidator<CheckNameFormat, String> {
    int max;
    int min;

    @Override
    public void initialize(CheckNameFormat constraintAnnotation) {
        max = constraintAnnotation.max();
        min = constraintAnnotation.min();
    }

    @Override
    public boolean isValid(String producerName, ConstraintValidatorContext cvc) {
        return (producerName != null) &&
                (producerName.toCharArray().length >= 2) && (producerName.toCharArray().length <= 12)
                && (producerName.matches("[A-Z][a-z]*"));
    }
}
