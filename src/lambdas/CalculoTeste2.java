package lambdas;

public class CalculoTeste2 {

	public static void main(String[] args) {
		
		Calculo calcular = (x, y) -> {
			return x + y;
		};
		System.out.println(calcular.executar(2, 3));
		
		calcular = (x, y) -> x * y;
		System.out.println(calcular.executar(2, 3));
		
		System.out.println(calcular.legal());
		
		System.out.println(Calculo.muitoLegal());
	}
	
}
