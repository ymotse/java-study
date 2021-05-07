package abstrato;

public class TesteAbstrato {

	public static void main(String[] args) {

		Animal animal = new Cachorro();
		System.out.println(animal.mover());

		Mamifero mamifero = new Cachorro();
		System.out.println(mamifero.mover());
		System.out.println(mamifero.mamar());
		System.out.println(mamifero.respirar());

	}

}
