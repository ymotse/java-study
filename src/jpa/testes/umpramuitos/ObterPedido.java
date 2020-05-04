package jpa.testes.umpramuitos;

import jpa.infra.DAO;
import jpa.modelo.umpramuitos.ItemPedido;
import jpa.modelo.umpramuitos.Pedido;

public class ObterPedido {
	
	public static void main(String[] args) {
		
		DAO<Pedido> dao = new DAO<>(Pedido.class);
		
		Pedido pedido = dao.obterPorId(1L);
		
		for (ItemPedido item : pedido.getItens()) {
			System.out.println("Produto: " + item.getProduto().getNome());
			System.out.println("Quantidade: " + item.getQuantidade());
		}
		
		dao.fechar();
	}
	
}
