package heranca.heranca_filhos;

import heranca.Animal;

public class Galinha extends Animal {
	
	public Galinha() {
		super(4, "milho");
	}
	
	public void voar() {
		System.out.println("voando...");
	}
	
	public void fazerBarulho() {
		System.out.println("Có, Có !");
	}
	
	
}
