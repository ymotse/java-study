package colecoes;

import java.util.HashSet;

public class ConjuntoBaguncado {

	public static void main(String[] args) {

		HashSet conjunto = new HashSet<>();
		conjunto.add(1.2);
		conjunto.add(true);
		conjunto.add("Teste");
		conjunto.add(1);
		conjunto.add('x');
		
		System.out.println("Tamanho é " + conjunto.size());
		
		conjunto.add("Teste");
		
		System.out.println("Tamanho é " + conjunto.size());
		
		conjunto.add("teste");
		
		System.out.println("Tamanho é " + conjunto.size());
		
		conjunto.remove('x');
		
		System.out.println("Tamanho é " + conjunto.size());

		System.out.println(conjunto.contains(true));
		System.out.println(conjunto.contains(false));
		System.out.println(conjunto.contains('x'));
		System.out.println(conjunto);
		
	}

}
