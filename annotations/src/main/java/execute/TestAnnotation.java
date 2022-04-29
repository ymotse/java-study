package execute;

import lombok.AllArgsConstructor;
import lombok.Data;
import validate.ValidateString;

import javax.validation.Validation;

@Data
@AllArgsConstructor
class Person {

	@ValidateString(minLength = 2)
	private String name;

	@ValidateString(minLength = 1, possibleValue = {"M", "F"})
	private String gender;
}

public class TestAnnotation {

	public static void main(String[] args) {
		Person personA = new Person("aA", "F");
		callValidate(personA);
		System.out.println(personA);

		Person personB = new Person("bx", "M");
		try {
			callValidate(personB);
			System.out.println(personB);
		} catch (Exception e) {
			System.out.println(personB + ": " + e.getCause().getMessage());
		}

		Person personC = new Person(null, "F");
		try {
			callValidate(personC);
			System.out.println(personC);
		} catch (Exception e) {
			System.out.println(personC + ": " + e.getCause().getMessage());
		}

		Person personD = new Person("Ab", "A");
		try {
			callValidate(personD);
			System.out.println(personD);
		} catch (Exception e) {
			System.out.println(personD + ": " + e.getCause().getMessage());
		}

	}

	private static void callValidate(Person person) {
		Validation.buildDefaultValidatorFactory().getValidator().validate(person);
	}

}
