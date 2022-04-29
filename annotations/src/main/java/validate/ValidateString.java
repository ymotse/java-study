package validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = ValidatorString.class)
public @interface ValidateString {

	String message() default "Invalid String value";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	int minLength();

	String[] possibleValue() default {};
}
