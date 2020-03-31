package colecoes.desafioComposicao;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

	final String nome;

	final List<Compra> compras = new ArrayList<>();

	public Cliente(String nome) {
		this.nome = nome;
	}
	
	double obterValorTotal() {
		double total = 0;
		
		for(Compra compraAtual : compras) {
			total += compraAtual.obterValorTotal();
		}
		return total;
	}

}
