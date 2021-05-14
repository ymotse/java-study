package polimorfismo.polimorfismo_desafio;

public class Jantar_Teste {
	
	public static void main(String[] args) {
		
		Pessoa convidado = new Pessoa(99.65);
		
		Arroz arroz = new Arroz(0.1);
		Feijao feijao = new Feijao(0.2);
		
		convidado.comer(arroz, feijao);

		System.out.println(convidado.getPeso());
		
		Sorvete sorteve = new Sorvete(0.4);
		convidado.comer(sorteve);
		
		System.out.println(convidado.getPeso());
		
	}
	
}
