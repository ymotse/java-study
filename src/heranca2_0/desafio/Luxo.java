package heranca2_0.desafio;

public interface Luxo {
	
	void ligarAr();
	void desligarAr();
	
	default int velocidadeDoAr() {
		return 1;
	}
	
}
