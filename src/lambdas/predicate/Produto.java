package lambdas.predicate;

public class Produto extends Object {

	public final String nome;
	public final double preco;
	public final double desconto;

	public Produto(String nome, double preco, double desconto) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.desconto = desconto;
	}
	
	public String toString() {
		double precoFinal = preco * (1 - desconto);
		return nome + " tem preco de R$ " + precoFinal;
	}

}
