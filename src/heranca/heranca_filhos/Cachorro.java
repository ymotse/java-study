package heranca.heranca_filhos;

import heranca.Animal;

public class Cachorro extends Animal {
	
	
	public Cachorro() {
		super(40, "carne");
	}
	
	
	public void enterrarOsso() {
		System.out.println("O cachorro de "+super.peso+"kg está enterrando o osso...");
	}
	
	
	public void fazerBarulho() {
		System.out.println("Au, Au !");
	}
	
	
	
}
