package myvalidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {IDFormat.class})
public @interface CheckIDFormat {
    String message() default "Incorrect ID format!\n";
    int min() default 4;
    int max() default 10;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
