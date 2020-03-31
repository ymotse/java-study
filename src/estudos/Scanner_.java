package estudos;

import java.util.Scanner; //importando a biblioteca Scanner, de java.util

public class Scanner_ { //Classe do tipo publica

	public static void main(String[]args){ //Metodo principal
	
	String variavel; //Criado uma variavel do tipo String
	
	System.out.println("Digite qualquer coisa para teste: ");
	@SuppressWarnings("resource")
	Scanner digite = new Scanner(System.in); //Criado uma variavel do tipo Scanner
	variavel = digite.nextLine(); //variavel String recebe o que foi armazenado na variavel tipo Scanner

	System.out.println("Voc� digitou: "+variavel);
	}
}
