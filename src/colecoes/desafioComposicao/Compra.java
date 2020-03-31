package colecoes.desafioComposicao;

import java.util.ArrayList;
import java.util.List;

public class Compra {

	List<Item> items = new ArrayList<>();

	void adicionarItem(Produto produto, int quantidade) {
		this.items.add(new Item(produto, quantidade));
	}

	void adicionarItem(String nome, double preco, int quantidade) {
		var produto = new Produto(nome, preco);
		
		this.items.add(new Item(produto, quantidade));
	}
	
	public double obterValorTotal() {
		double total = 0;
		
		for(Item item : items) {
			total += item.qtde * item.produto.preco;
		}
		return total;
	}
	
}
