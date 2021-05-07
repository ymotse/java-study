package lambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Ordenacao {
	
	public static void main(String[] args) {
		List<String> lista = Arrays.asList("Beto", "Ana", "Paulo", "Maria");
		
		System.out.println("Original:");
		lista.forEach(l -> System.out.println(l));
		
		
		System.out.println("\nCrescente:");
		lista.sort(Comparator.comparing(p -> p));
//		Collections.sort(lista); // java.utils
		lista.forEach(l -> System.out.println(l));
		
		
		System.out.println("\nDecrescente:");
		lista.sort(Comparator.reverseOrder());
//		Collections.reverse(lista); // java.utils
		lista.forEach(l -> System.out.println(l));
	}
	
}
