package estudos;
/*  	Encapsulamento server para proteger as variaveis, criando um campo de forca ao 
 * 	redor das variaveis, de forma que ninguem possa configura-la com algum valor inapropriado.
		A maioria dos valores que utilizamos dentro das nossas classes sao codificadas com 
	algumas definicoes de limites, por exemplo:
		Varias coisas nao funcionariam se os numeros utilizados fossem negativos, 
	exemplo seria, a velocidade de um aviao, o peso de um halter, a quantidade de banheiros 
	de uma casa. Varios desses valores, existem um limite para que sua aplicacao possa 
	funcionar corretamente, e quando voce forca outros codigos a passar pelos seus metodos 
	de configuracao, voce tem como validar se o parametro que esta sendo informado eh viavel.
		Voce tem como garantir que a sua variavel soh vai receber valores validos, mas caso 
	existir um tipo de variavel que exija algum limite, entao nao precisa criar metodos de 
	configuracao, ou seja, nao precisa encapsular essa variavel, para nao gerar um excesso de codigo.
*/

//MODIFICADORES DE ACESSO

//PRIVATE: eh acessivel somente para membros (atributo, metodo, variavel) da propria classe 
//PACKAGE: eh acessivel a todos os membros dentro do mesmo pacote da propria classe
//PRIVATE: eh utilizado para restringir acesso aos filhos de uma classe (sub classe).
//PUBLIC: indica que o atributo, metodo e variavel, eh acessivel em qualquer lugar, por qualquer membro.

public class Encapsulamento { //Classe do tipo Publica
		// A ideia dessa classe eh dar um exemplo de capsulamento.
	
	private String nome;   // com o modificador "private", essa variavel soh sera acessivel nessa classe.
	
	// get = capturar (usado para criar um metodo para captura de informacao)
	// quando a variavel eh Boolean,  metodo de captura eh is
	
	// set = metodo de configuracao, atribuir algum valor;
	

	
	public String getNome(){
		return nome;
	}
	public void setNome(String n){
		this.nome = n;
		//dando referencia a variavel private String nome (primeira variavel criada, no topo do codigo)
	}
	
	public static void main(String[] args) {
		Encapsulamento funcionario = new Encapsulamento();
		@SuppressWarnings("unused")
		String n = funcionario.getNome();
		funcionario.setNome("Joao");
		
	}

}
