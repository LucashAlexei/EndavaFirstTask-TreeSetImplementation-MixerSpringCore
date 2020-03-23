package myvalidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {NameFormat.class})
public @interface CheckNameFormat {
    String message() default "Incorrect producer name!\n";
    int min() default 2;
    int max() default 12;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
