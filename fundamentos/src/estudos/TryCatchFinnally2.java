/* 		-= TRATAMENTO DE EXCECOES COM MULTI CATCH, STACKTRACE, e THROWS =- */

package estudos;

import java.util.InputMismatchException;
import java.util.Scanner;


public class TryCatchFinnally2 {

	// Declarado no metodo os tipos de excecoes que pode lancar, atraves do Throws;
	public static void dividir(Scanner s) throws InputMismatchException, ArithmeticException{
		System.out.print("Numero: ");
		int a = s.nextInt();
		System.out.print("Divisor: ");
		int b = s.nextInt();

		System.out.println(a / b);
	}
	
	// Metodo Main:
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		boolean continua = true;
		
		do{
			try {
				dividir(s);
				continua = false;
			}
			
			// Multi Catch:
			catch(InputMismatchException | ArithmeticException erro1){
				System.err.println("Numero invalido.");
				erro1.printStackTrace(); //StackTrace
				s.nextLine(); //descarta a entrada errada e libera novamente para o usuario;
			}
			finally{
				System.out.println("Finally executado.");
			}
		}
		while(continua);
		
	}

}
