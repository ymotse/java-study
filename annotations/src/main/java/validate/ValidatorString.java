package validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.Objects;

public class ValidatorString implements ConstraintValidator<ValidateString, String> {

	private int minLength;

	private String[] possibleValue;

	@Override
	public void initialize(ValidateString constraintAnnotation) {
		this.minLength = constraintAnnotation.minLength();
		this.possibleValue = constraintAnnotation.possibleValue();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(!Objects.isNull(possibleValue) && possibleValue.length > 0) {
			long countMatch = Arrays.stream(possibleValue).filter(pv -> pv.equals(value)).count();

			if(countMatch == 0) {
				throw new IllegalArgumentException("String value should be like: " + Arrays.toString(possibleValue));
			}
		}

		if(Objects.isNull(value) || value.trim().isEmpty()) {
			throw new IllegalArgumentException("String value cannot be null or empty");
		}

		if(value.trim().length() < minLength) {
			throw new IllegalArgumentException("String value cannot be less than " + minLength);
		}

		return true;
	}
}
