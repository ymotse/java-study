package heranca2_0.desafio;

public class Carro {

	int velocidadeAtual;

	void acelerar() {
		velocidadeAtual += 5;
	}

	void frear() {
		velocidadeAtual = (velocidadeAtual >= 5) ? velocidadeAtual - 5 : 0;
	}
	
	
	public String toString() {
		return "Velocidade atual é " + velocidadeAtual + "Km/h";
	}
	
}
