package estudos;

import java.util.Scanner;
public class Continue {  //Classe do tipo Publica
public static void main (String [] args){
	
        for (int contador=1; contador<=100; contador++){
        	
        	System.out.println("Digite um n�mero: ");
			@SuppressWarnings("resource")
			Scanner imprimi = new Scanner(System.in);
        	contador = imprimi.nextInt();
        	
            if (contador%5!=0) // se 'contador' dividido por 5, tiver Resto diferente de 0 
                continue;
            
            
           /* SE O NUMERO DIGITADO (CONTADOR) NAO FOR MULTIPLO DE 5
              TOD0 O CODIGO ABAIXO SERA IGNORADO
              E O LOOP CONTINUA COM O PROXIMO NUMERO */
        System.out.println("Contador: "+contador);
        }
    }
}
