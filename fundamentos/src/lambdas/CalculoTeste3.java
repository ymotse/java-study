package lambdas;

import java.util.function.BinaryOperator;

public class CalculoTeste3 {

	public static void main(String[] args) {
		
		BinaryOperator<Double> calcular = (x, y) -> {
			return x + y;
		};
		System.out.println(calcular.apply(2.0, 3.0));
		
		calcular = (x, y) -> x * y;
		System.out.println(calcular.apply(2.0, 3.0));
		
		
		BinaryOperator<Integer> calc = (x, y) -> x - y;
		System.out.println(calc.apply(7, 4));
		
	}
	
}
