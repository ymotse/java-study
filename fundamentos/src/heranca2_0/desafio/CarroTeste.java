package heranca2_0.desafio;

public class CarroTeste {
	
	public static void main(String[] args) {
		
		Carro c1 = new Civic();
		
		c1.acelerar();
		System.out.println(c1);
		
		c1.acelerar();
		System.out.println(c1);
		
		c1.acelerar();
		System.out.println(c1);
		System.out.println();
		
		Ferrari ferrari = new Ferrari();
		
		ferrari.ligarTurbo();
		ferrari.acelerar();
		System.out.println(ferrari);
		
		System.out.println("ferrari.velocidadeDoAr: " + ferrari.velocidadeDoAr());
		
		ferrari.acelerar();
		System.out.println(ferrari);
		
		ferrari.desligarTurbo();
		ferrari.acelerar();
		System.out.println(ferrari);
		
		ferrari.acelerar();
		System.out.println(ferrari);
		
		ferrari.acelerar();
		System.out.println(ferrari);
		
		ferrari.acelerar();
		System.out.println(ferrari);
	}
	
}
