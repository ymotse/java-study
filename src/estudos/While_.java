package estudos;
import java.util.Scanner;
import java.util.ArrayList;
public class While_ {
public static void main(String[]args){
	System.out.println("Digite qualquer Nome (para sair digite 'SAIR'): ");
	
	String palavra;
	ArrayList<String> palavras = new ArrayList<>();
	
	@SuppressWarnings("resource")
	Scanner imprimi = new Scanner(System.in);
	
	while (!"SAIR".equals(palavra = imprimi.nextLine())){	
		palavras.add(palavra);
	}
System.out.println(palavras.toString());

}
}
