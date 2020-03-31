/* Programa que o usuario digitara quatro paises, e depois digitara uma posicao entre 0 a 4.
 * Apos isso, o programa listara os paises digitados e a posicao digitada pelo usuario;
 * listara quantos paises tem na lista, e se existe um paes na lista. */

package estudos;
import java.util.ArrayList; //Importando a biblioteca ArrayList, do java.util
import java.util.Scanner; //Importando a biblioteca Scanner, do java.util

public class ArrayListComScanner { //Classe do tipo Publica
public static void main(String[]args){ //metodo Principal

	

	@SuppressWarnings("resource")
	Scanner pais = new Scanner(System.in); //Iniciando uma variavel do tipo Scanner
	
	ArrayList <String> paises = new ArrayList <String> (); //Criando um ArrayList do Tipo String
	
	System.out.println("Digite o primeiro pais:");
	paises.add(pais.nextLine()); //O ArrayList adicionara um paes que o usuario digitar
	System.out.println("Digite o segundo pais:");
	paises.add(pais.nextLine()); //O ArrayList adicionara um paes que o usuario digitar
	System.out.println("Digite o terceiro pais:");
	paises.add(pais.nextLine()); //O ArrayList adicionara um paes que o usuario digitar
	System.out.println("Digite o ultimo pais:");
	paises.add(pais.nextLine()); //O ArrayList adicionara um paes que o usuario digitar
	
	System.out.println("Digite de 0 a 3:");
	int posicaoDoPais = pais.nextInt(); //A variavel do tipo inteiro armazenara a posicao que o usuario digitar
	
	System.out.println("Os paises digitados foram: "+paises.toString()); //toString lista todos os paises digitados pelo usuario
	System.out.println("A posicao digitada foi "+posicaoDoPais+", logo, eh o pais "+paises.get(posicaoDoPais)); //get lista a posicao digitada pelo usuario
	System.out.println("Foram listados "+paises.size()+" paises."); //size mostra o tamanho do ArrayList
	
	//perguntar se tem tal cor, recebera 'true' para 'sim', ou 'false' para 'nao'
	System.out.println("Possui o pais Brasil? "+paises.contains("Brasil"));
	
}
}
