package heranca.heranca_filhos;

import heranca.Animal;

public class Animal_Teste {

	
	public static void barulho(Animal animal) {
		animal.fazerBarulho();
	}
	
	
	public static void main(String[] args) {
		
		Animal generico = new Animal(0, null);
		Animal fritz = new Cachorro();
		Animal carijo = new Galinha();
		
		fritz.comer();
		fritz.fazerBarulho();
		
		System.out.println(fritz instanceof Cachorro); //fritz é um cachorro.
		System.out.println(fritz instanceof Animal); //fritz é um animal.
		
		carijo.fazerBarulho();
		generico.fazerBarulho();
		
		barulho(fritz);
	}

}
