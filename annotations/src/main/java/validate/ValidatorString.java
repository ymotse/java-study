package validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class ValidatorString implements ConstraintValidator<ValidateString, String> {

	private int minLength;

	@Override
	public void initialize(ValidateString constraintAnnotation) {
		this.minLength = constraintAnnotation.minLength();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(Objects.isNull(value) || value.trim().isEmpty()) {
			throw new IllegalArgumentException("String value cannot be null or empty");
		}

		if(value.trim().length() < minLength) {
			throw new IllegalArgumentException("String value cannot be less than " + minLength);
		}

		return true;
	}
}
