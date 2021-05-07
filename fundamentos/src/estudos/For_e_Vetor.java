// TABUADA USANDO O "FOR" E "SCANNER"

package estudos;
import java.util.Scanner;
public class For_e_Vetor {
public static void main(String[]args){
	
	int i,digitado;
	int vetor[] = new int[11];	
	
	System.out.println("TABUADA!");
	System.out.println("Digite qual o numero da Tabuada que quer saber:");
	
	@SuppressWarnings("resource")
	Scanner imprimi = new Scanner(System.in);
	digitado = imprimi.nextInt();

	for(i = 1; i <= 10; i++)
	{
		vetor[i] = i;

	
	System.out.println(digitado+" x "+vetor[i]+" = "+(digitado * vetor[i]));
	
	}
									}
	
						}
