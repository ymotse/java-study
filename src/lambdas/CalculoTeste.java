package lambdas;

public class CalculoTeste {
	
	public static void main(String[] args) {
		
		Calculo soma = new Somar();
		System.out.println(soma.executar(2, 3));
		
		soma = new Multiplicar();
		System.out.println(soma.executar(2, 3));
		
	}
	
}
