package encapsulamento;

public class Pessoa {

	private int idade;
	private String nome;

	public Pessoa(String nome, int idade) {
		setNome(nome);
		setIdade(idade);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		idade = Math.abs(idade);

		if (idade >= 0 && idade <= 120) {
			this.idade = idade;
		}
	}

	
	public String toString() {
		return "Olá, sou " + this.nome + ", e tenho " + this.idade + " anos. \n";
	}
	
}
