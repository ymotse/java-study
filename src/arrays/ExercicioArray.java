package arrays;

import java.util.Arrays;

public class ExercicioArray {
	
	public static void main(String[] args) {
		
		double notasAlunoA[] = new double[3];
		
		notasAlunoA[0] = 7.9;
		notasAlunoA[1] = 9;
		notasAlunoA[2] = 6.7;
		
		System.out.println(notasAlunoA[0]);
		System.out.println(Arrays.toString(notasAlunoA));
		
		double totalNotasA = 0;
		for (double d : notasAlunoA)
			totalNotasA += d;
		
		System.out.println(String.format("%.2f", (totalNotasA / notasAlunoA.length)));
		
		
		
		
		double notasAlunoB[] = {5.6, 2.9, 8.1, 6.9};
		
		System.out.println(Arrays.toString(notasAlunoB));
	}
	
}
