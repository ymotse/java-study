package heranca2_0.desafio;

public class Ferrari extends Carro {
	
	
	Ferrari() {
		this(300);
	}
	
	Ferrari(int velocidadeMaxima) {
		super(velocidadeMaxima);
		delta = 200;
	}
	
}
