package estudos;
import java.util.Scanner;
public class LoginSimples {
	public static void main(String[]args){
		
	String Nome1, Nome2;
	int ID1, ID2;
	

		@SuppressWarnings("resource")
		Scanner imprimi = new Scanner(System.in);
		System.out.println("Digite o nome para ser cadastrado: ");
		Nome1 = imprimi.nextLine();
		System.out.println("Digite o numero para ser cadastrado como ID: ");
		ID1 = imprimi.nextInt();
		
			System.out.println("Bem Vindo "+Nome1+", ID:"+ID1+" - CADASTRO COM SUCESSO!");
	

		System.out.println("LOGIN - Digite o nome de usuario: ");
		Nome2 = imprimi.nextLine();
		System.out.println("LOGIN - Digite o ID: ");
		ID2 = imprimi.nextInt();
		
	// Se Nome1 for diferente de Nome2, OU, ID1 for diferente de ID2:	
		if (!Nome1.equals(Nome2) || ID1 != ID2){
			System.out.println("USUARIO OU ID ERRADO!!!");
		}
		else{ 		// senao:
			
			System.out.println("Bem Vindo "+Nome1+", ID:"+ID1+" - LOGIN COM SUCESSO!");
		}
		}
	}


