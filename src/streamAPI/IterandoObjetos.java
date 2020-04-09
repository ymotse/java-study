package streamAPI;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class IterandoObjetos {
	
	public static void main(String[] args) {
		
		List<String> aprovados = Arrays.asList("Ana","Bia","Lia","Gui");
		
		
		System.out.println("Usando Iterator:");
		
		Iterator<String> it = aprovados.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("\nUsando Stream:");
		Stream<String> stream = aprovados.stream();
		stream.forEach(System.out::println);
		
	}
	
}
