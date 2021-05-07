package estudos;
import java.util.Scanner;
import java.util.Random;
public class JogoDosDados {
public static void main(String[]args){
	

	System.out.println("Qual o seu palpite?");
	@SuppressWarnings("resource")
	Scanner imprimi = new Scanner(System.in);
	int palpite = imprimi.nextInt();

	Random numero = new Random();
	int dado = numero.nextInt(6); //6 possibilidades, de 0 a 5
	
	System.out.println("Palpite = "+palpite);
	System.out.println("Dado = "+dado);
	
if(palpite == dado){
	
	System.out.println("Voce Acertou!");
				   }
else{
	System.out.println("Voce Errou!");
	}	
				}
			}