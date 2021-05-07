package estudos;

import java.util.Scanner;
public class Break {  //Classe do tipo Publica
public static void main (String args []){
	
	int contador;

	System.out.println("Digite um numero qualquer exceto o numero '10' e/ou maior que 99: ");
        for (contador=0; contador<=100; contador++){
        	

			@SuppressWarnings("resource")
			Scanner imprimi = new Scanner(System.in);
        	contador = imprimi.nextInt();
  
            if (contador==10){
                System.out.println("Voce digitou um numero nao permitido!");
                    break;
                }
        	
            System.out.println("Numero digitado foi "+contador+"\n"+"Digite um numero novamente: ");
            

        }
    }
}
