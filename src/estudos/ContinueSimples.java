package estudos;

import java.util.Scanner;

public class ContinueSimples { //Classe do tipo Publica

	public static void main(String[] args) {

		for  (int valor = 1; valor < 100; valor++){
		
			System.out.println("DIGITE: ");
		@SuppressWarnings("resource")
		Scanner imprimi = new Scanner(System.in);
		valor = imprimi.nextInt();
		
		if (valor == 2)
			continue;
		//break;
		
		System.out.println("Parabens!!! "+ valor);
		
		
	}
	}
}
