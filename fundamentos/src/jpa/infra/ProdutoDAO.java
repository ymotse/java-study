package jpa.infra;

import jpa.modelo.Produto;

public class ProdutoDAO extends DAO<Produto> {
	
	public ProdutoDAO() {
		super(Produto.class);
	}
	
}
