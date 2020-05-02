package jpa.testes;

import jpa.infra.DAO;
import jpa.modelo.Produto;

public class NovoProduto {
	
	public static void main(String[] args) {
		
		Produto produto = new Produto("Monitor 23", 789.99);
		
		DAO<Produto> dao = new DAO<>(Produto.class);
//		dao.abrirT().incluir(produto).fecharT().fechar();
		dao.abrirT().incluir(produto).fecharT();
		
		
		Produto produto2 = new Produto("Notebook", 2987.78);
		dao.incluirAtomico(produto2).fechar();
		
	}
	
}
