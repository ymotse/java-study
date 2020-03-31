package estudos;
import java.util.Scanner;
public class OperadorTernario {
public static void main(String[]args){
	
	//Operador Ternario: aceita 3 operandos, exemplo:
	
	int idade;
	
	System.out.println("Digite sua Idade: ");
	@SuppressWarnings("resource")
	Scanner imprimi = new Scanner(System.in);
	idade = imprimi.nextInt();
	
	String x = (idade >= 18) ? "Maior de Idade" : "Menor de Idade";
	System.out.println(x);
	
	
	
}
}
