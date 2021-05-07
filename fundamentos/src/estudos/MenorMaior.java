package estudos;
import java.util.Scanner;
public class MenorMaior {
	public static void main (String []args){
		
		int maior, menor;
		int [] Numeros;
		Numeros = new int[3];
		
		
		System.out.println("Digite o primeiro numero: ");
		@SuppressWarnings("resource")
		Scanner imprimir = new Scanner(System.in);
		Numeros[0] = imprimir.nextInt();
		maior = Numeros[0];
		menor = Numeros[0];
		
		System.out.println("Digite o segundo numero: ");
		Numeros[1] = imprimir.nextInt();
		if (Numeros[1] > maior) {
			maior = Numeros[1];
		}	else {
			maior = Numeros[0];
		}
		

		if (Numeros[1] < menor) {
			menor = Numeros[1];
		}	else {
			menor = Numeros[0];
		}
		
		
		System.out.println("Digite o terceiro numero: ");
		Numeros[2] = imprimir.nextInt();
		if (Numeros[2] > maior) {
			maior = Numeros[2];
		}	else {
			maior = Numeros[0];
		}
		

		if (Numeros[2] < menor) {
			menor = Numeros[2];
		}	else {
			menor = Numeros[0];
		}

		
		System.out.println("Primeiro Numero: "+Numeros[0]);
		System.out.println("Segundo Numero: "+Numeros[1]);
		System.out.println("Terceiro Numero: "+Numeros[2]);
		System.out.println("Menor Numero: "+menor);
		System.out.println("Maior Numero: "+maior);

	}
	
}
