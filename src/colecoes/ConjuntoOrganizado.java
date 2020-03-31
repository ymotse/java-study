package colecoes;

import java.util.TreeSet;

public class ConjuntoOrganizado {
	
	public static void main(String[] args) {
		
		TreeSet<String> listaAprovados = new TreeSet<>();
		listaAprovados.add("Ana");
		listaAprovados.add("Pedro");
		listaAprovados.add("Lucas");
		listaAprovados.add("Maria");
		listaAprovados.add("João");
		
		for (String string : listaAprovados) {
			System.out.println(string);
		}
	}
	
}
