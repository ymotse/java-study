import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validate.ValidateString;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidatorStringTest {

	private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

	@Data
	@AllArgsConstructor
	static class PersonTest {

		@ValidateString(minLength = 4)
		private String requiredString;
	}

	@Test
	@DisplayName("ValidatorString isValid does not throw when successful")
	void isValid_doesNotThrow_whenSuccessful() {
		final Set<ConstraintViolation<PersonTest>> constraintViolations = validator.validate(new PersonTest("test"));

		assertTrue(constraintViolations.isEmpty());
	}

	@Test
	@DisplayName("ValidatorString isValid throws Exception when string is invalid")
	void isValid_throwsException_whenStringIsInvalid() {
		assertThrows(
			ValidationException.class,
			() -> validator.validate(new PersonTest("tes"))
		);
	}
}
