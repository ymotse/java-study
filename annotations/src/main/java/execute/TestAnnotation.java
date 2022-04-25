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
}

public class TestAnnotation {

	public static void main(String[] args) {
		Person personA = new Person("aA");
		callValidate(personA);
		System.out.println(personA);

		try {
			Person personB = new Person("b");
			callValidate(personB);
			System.out.println(personB);
		} catch (Exception e) {
			System.out.println(e.getCause().getMessage());
		}

		try {
			Person personC = new Person(null);
			callValidate(personC);
			System.out.println(personC);
		} catch (Exception e) {
			System.out.println(e.getCause().getMessage());
		}

	}

	private static void callValidate(Person person) {
		Validation.buildDefaultValidatorFactory().getValidator().validate(person);
	}

}
