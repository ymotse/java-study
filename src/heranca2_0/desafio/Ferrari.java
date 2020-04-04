package heranca2_0.desafio;

public class Ferrari extends Carro {
	
	
	public Ferrari() {
		this(300);
	}
	
	public Ferrari(int velocidadeMaxima) {
		super(velocidadeMaxima);
		delta = 200;
	}
	
}
