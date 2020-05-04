package jpa.testes.umpramuitos;

import jpa.infra.DAO;
import jpa.modelo.Produto;
import jpa.modelo.umpramuitos.ItemPedido;
import jpa.modelo.umpramuitos.Pedido;

public class NovoPedido {
	
	public static void main(String[] args) {
		
		DAO<Object> dao = new DAO<>();
		
		Pedido pedido = new Pedido();
		Produto produto = new Produto("Geladeira", 2789.99);
		ItemPedido itemPedido = new ItemPedido(pedido, produto, 10);
		
		dao.abrirT()
			.incluir(produto)
			.incluir(pedido)
			.incluir(itemPedido)
			.fecharT()
			.fechar();
	}
	
}
