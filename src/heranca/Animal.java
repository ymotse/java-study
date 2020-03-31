package heranca;

public class Animal {
	
	protected double peso;
	public String comida;
	
	
//	public Animal() {
//		this(0,null);
//	}
	
	public Animal(double peso, String comida) {
		this.peso = peso;
		this.comida = comida;
	}
	
	public void comer() {
		System.out.println("comendo..");
	}
	
	public void movimentar() {
		System.out.println("movimentando...");
	}
	
	public void fazerBarulho() {
		System.out.println("fazer barulho!");
	}
	
}