package estudos;
import java.util.Scanner;
import java.util.Random;
public class Random_ {
	public static void main(String[]args){
	int numero,numero2;
	
	System.out.println("Digite um valor de 'zero'(0) a 'tres'(3) para seu palpite: ");
	@SuppressWarnings("resource")
	Scanner imprimi = new Scanner(System.in);
	numero = imprimi.nextInt();
	
	// Random nada mais eh do que o sistema escolher um valor aleatorio
	Random imprimiRandom = new Random();
	numero2 = imprimiRandom.nextInt(3);
	
	System.out.println("O numero que voce escolheu foi "+numero+"\n"+
	"O n�mero aleat�rio que o sistema escolheu foi "+numero2);
	
	if (numero2 == 0){
	System.out.println("Vamos para Praia!!");
				}
	if (numero2 == 1){
	System.out.println("Vamos ficar em casa!");
				}
	if (numero2 == 2){
	System.out.println("Vamos estudar!");
				}
	if(numero2 == 3){
	System.out.println("Vamos sair para qualquer lugar!");
					}
			}
	}