package estudos;
import java.util.Arrays;

public class ArraySimples {  //Classe do tipo Publica

	public static void main (String [] args){
		
		String [] ArrayPaises = {"Alemanha", "Brasil", "Estados Unidos", "Japao"};
		
		// Exibindo a posicao 1, ou seja, o segundo elemento (Brasil)
		System.out.println( ArrayPaises[1] );

		//	Alterando o dado de uma posicao, como por exemplo a posicao 1
		ArrayPaises[1] = "BRASIL";
		System.out.println( ArrayPaises[1] );
		
		// Descobrir quantas posicao ha no Array criado
		System.out.println(ArrayPaises.length + " posicoes");
		
		/* Vamos importar uma biblioteca para a manipulacao de Arrays :
		  	 import java.util.Arrays;		 */
		// O metodo toString recebe um parametro, no caso o Array que deseja apresentar na tela.
		System.out.println(Arrays.toString(ArrayPaises));
		
		/* Vamos fazer uma pesquisa dentro do Array para saber se h� um dado especifico e a posicao do mesmo.
		 * Exemplo: Pesquisar se existe o paes Estados Unidos, dentro do Array criado		*/
		// Usamos o objeto Arrays, e o metodo binarySearch
		int posicao = Arrays.binarySearch(ArrayPaises,"Estados Unidos");
		System.out.println(posicao);

	}
}
