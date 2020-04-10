package excecao;

import lambdas.predicate.Produto;

public class Basico {
	
	public static void main(String[] args) {
		
		Produto p1 = null;
		
		try {
			imprimirProduto(p1);
		} catch (Exception excecao) {
			System.out.println("Ocorreu um erro no momento de imprimir o nome do produto.");
		}
		
		try {
			System.out.println(7 / 0);
		} catch (ArithmeticException e) {
			System.out.println("Ocorreu o erro: " + e.getMessage());
		}

		System.out.println("Fim.");
	}
	
	
	public static void imprimirProduto(Produto produto) {
		System.out.println(produto.nome);
	}
	
}
