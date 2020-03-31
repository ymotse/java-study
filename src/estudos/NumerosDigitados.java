/* Programa que o usuario digite cinco numeros, e mostra na tela os numeros 
digitados */

package estudos;
import java.util.Scanner;
public class NumerosDigitados {
	
	public static void main(String[] args) {
	

		int [] vetor = new int[5];
		 
		for (int contador = 0; contador < 5; contador++ ){
			System.out.println("Digite qualquer numero: ");
			@SuppressWarnings("resource")
			Scanner ler = new Scanner(System.in);
			vetor[contador] = ler.nextInt();

			System.out.println("Digitado: " + vetor[contador] + "\n");
		}
		
		}
		
	}


