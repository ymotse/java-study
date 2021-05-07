package estudos;
import java.util.ArrayList;
public class ArrayList_ {  //Classe do tipo Publica
	public static void main(String[]args){

		ArrayList<String> cores = new ArrayList<>();  //Criando um ArrayList do Tipo String
		cores.add(0,"Branco"); //adicionando e especificando a posicao 0 
		cores.add(1,"Azul");	//adicionando e especificando a posicao 1
		cores.add(2,"Vermelho");	//adicionando e especificando a posicao 2 
		
		System.out.println(cores.toString()); //mostrar todos dados declarados no ArrayList 'cores'
		System.out.println("Tamanho = "+cores.size()); //posicoes do ArrayList 'cores'
		System.out.println("Elemento = "+cores.get(2)); //mostrar o elemento na posicao '2'
		System.out.println("Indice do Branco = "+cores.indexOf("Branco") ); //posicao do dado 'Branco'
		
		cores.remove("Vermelho"); //remover cor
		System.out.println(cores.toString());	//mostrar todos dados declarados no ArrayList 'cores'
		
		
		//perguntar se tem tal cor, receber� 'true' para 'sim', ou 'false' para 'nao'
		System.out.println("Tem Amarelo? "+cores.contains("Amarelo"));
		System.out.println("Tem Vermelho? " +cores.contains("Vermelho"));
		}
	}