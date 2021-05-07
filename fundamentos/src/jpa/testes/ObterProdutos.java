package jpa.testes;

import java.util.List;

import jpa.infra.ProdutoDAO;
import jpa.modelo.Produto;

public class ObterProdutos {
	
	public static void main(String[] args) {
	
		ProdutoDAO dao = new ProdutoDAO();
		List<Produto> produtos = dao.obterTodos();
		
		for (Produto produto : produtos) {
			System.out.println("ID: " + produto.getId() 
			+ " | Nome: " + produto.getNome() 
			+ " | Preço: " + produto.getPreco());
		}
		
		double precoTotal = produtos.stream()
				.map(p -> p.getPreco())
				.reduce(0.0, (total, precoAtual) -> total + precoAtual)
				.doubleValue();
		
		System.out.println("O valor total é R$ " + precoTotal);
		
		dao.fechar();
	}
	
}
