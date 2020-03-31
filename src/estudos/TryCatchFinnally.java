/* 		-= TRATAMENTO DE EXCECOES =- */

package estudos;

import java.util.InputMismatchException;
import java.util.Scanner;


public class TryCatchFinnally {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		boolean continua = true;
		
		do{
			try {

				System.out.print("Numero: ");
				int a = s.nextInt();
				System.out.print("Divisor: ");
				int b = s.nextInt();

				System.out.println(a / b);
				continua = false;
			}
			catch(InputMismatchException erro2){
				System.err.println("Numero deve ser inteiro.");
				s.nextLine(); //descarta a entrada errada e libera novamente para o usuario;
			}
			catch(ArithmeticException erro1){
				System.err.println("Divisor deve ser diferente de Zero.");
			}
			finally{
				System.out.println("Finally executado.");
			}
		}
		while(continua);
		
	}

}
