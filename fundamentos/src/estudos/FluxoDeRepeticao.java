package estudos;
import java.util.Scanner;
import java.util.ArrayList;
public class FluxoDeRepeticao {
public static void main (String[]args){
	
				/*			 Fluxo de Repeticao 	 	-  	 	WHILE */
	
	ArrayList<String> produtos = new ArrayList<>();
	@SuppressWarnings("resource")
	Scanner imprimi = new Scanner (System.in);
	System.out.println("Liste seus Produtos: Para sair escreva 'FIM'.");
	
	String produto;
	while(!"FIM".equals(produto = imprimi.nextLine())) {
		produtos.add(produto);	
	}
	System.out.println(produtos.toString());
	}		
}
