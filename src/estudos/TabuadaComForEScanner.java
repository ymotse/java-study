package estudos;
import java.util.Scanner;

public class TabuadaComForEScanner {
	public static void main(String[] args) {

		
		@SuppressWarnings("resource")
		Scanner imprimi = new Scanner (System.in);
		System.out.println("Digite um n�mero para ver a tabuada dele, at� dez(10): ");
		int Ndigitado = imprimi.nextInt();
		
		int contador, resultado;
		
		//		Para contador igual a 0; contador menor que 11; contador incrementa mais 1:
		for (contador = 0; contador < 11; contador ++){
			resultado = (Ndigitado * contador);
			
			System.out.println(Ndigitado+" x "+contador+" = "+resultado);
			
		}
		
	}

}
