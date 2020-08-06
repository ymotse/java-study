package imutabilidade;

public class Imutabilidade1 {

	public static void main(String[] args) {
		
		String nome = "Yitshhaq Correa";
		
		nome.replace("Correa", "Fukushima");
		
		System.out.println(nome);
		
		String novoNome = nome.replace("Correa", "Fukushima");
		
		System.out.println(novoNome);
		
	}
	
}
