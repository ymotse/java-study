package streamAPI;

import java.util.Arrays;
import java.util.List;

public class OutrosMetodos {

	public static void main(String[] args) {
		Aluno a1 = new Aluno("Ana", 7.1);
		Aluno a2 = new Aluno("Luna", 6.1);
		Aluno a3 = new Aluno("Gui", 8.1);
		Aluno a4 = new Aluno("Paulo", 10);
		Aluno a5 = new Aluno("Pedro", 10);
		Aluno a6 = new Aluno("Gabi", 10);
		Aluno a7 = new Aluno("Gabi", 10);
		Aluno a8 = new Aluno("Maria", 10);
		Aluno a9 = new Aluno("Gabi", 10);
		Aluno a10 = new Aluno("Maria", 10);
		
		List<Aluno> alunos = Arrays.asList(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10);
		
		System.out.println("Distinct...");
		
		alunos.stream().distinct().forEach(System.out::println);
		
		System.out.println("\n\nSkip/Limit");
		alunos.stream()
		.distinct()
		.skip(2)
		.limit(2)
		.forEach(System.out::println);

		System.out.println("\n\ntakeWhile");
		alunos.stream()
		.skip(2)
		.distinct()
		.takeWhile(a -> a.nota >= 7)
		.forEach(System.out::println);
	}
	
}
