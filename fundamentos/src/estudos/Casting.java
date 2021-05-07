package estudos;

public class Casting {
	 public static void main(String[]args){
		 
		 /* Casting eh usado para arredondar(converter) e armazenar um valor de um tipo de variavel,
		    em outro tipo de variavel, sem haver erro de compilacao, ou perda de valores. */
		 
		  // EX.: um double pode ter um inteiro, mas um inteiro nao pode ter um double
		 double d = 3.14;
		 int i = (int)d;
		 System.out.println(i);
	 
		 // OU:
		 long l = 100000000;
		 int i2 = (int)l;
		 System.out.println(i2);
	 }
}
