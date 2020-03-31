package estudos;
// As variveis podem ter seus dados armazenados, alterados.
// Ja as constantes n�o podem ter alteracao, depois de declaradas.
public class variaveisEconstantes {
	public static void main(String[] args) {

		
		//Declarando variaveis:
		int numero = 123;
		String nome = "Joao";
		double temperatura = 28.5;
		boolean mentindo = true;
		
		
		//Declarando constantes: (Se declara uma constante com o modificador 'final'
		final double PI = 3.14;
		final char SEXO_MASCULINO = 'M';
		final char SEXO_FEMININO = 'F';
		//	 O certo de declarar constantes, eh sempre escrever o nome da contante com letras maiuculas, se for nome composto,
		//  separar com underline _
		
		
		System.out.println("Variaveis: \n"+"Variavel tipo int: "+ numero +
														  "\n Variavel tipo String: "+ nome +
														  "\n Variavel tipo double: "+temperatura +
														  "\n Variavel tipo boolean"+ mentindo);
		
		System.out.println("\n Constantes: "+"\n Constante tipo double: "+PI+
																	"\n Constante tipo char: "+SEXO_MASCULINO+
																	"\n Constante tipo char: "+SEXO_FEMININO);
	}

}
