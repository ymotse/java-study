package estudos;
import java.util.Scanner;  //Importando a biblioteca Scanner, do java.util

public class ArrayComScanner {  //Classe do tipo Publica
	public static void main(String[] args) {

		float [] numero = new float [5];


		@SuppressWarnings("resource")
		Scanner imprimi1 = new Scanner(System.in); //Iniciando uma variavel do tipo Scanner
		System.out.println("Digite o Primeiro valor: ");
		numero[0] = imprimi1.nextFloat();
		System.out.println("Digite o Segundo valor: ");
		numero[1] = imprimi1.nextFloat();
		System.out.println("Digite o Terceiro valor: ");
		numero[2] = imprimi1.nextFloat();
		System.out.println("Digite o Quarto valor: ");
		numero[3] = imprimi1.nextFloat();
		System.out.println("Digite o Quinto valor: ");
		numero[4] = imprimi1.nextFloat();
		
		System.out.println("Primeiro N�mero Digitado: "+numero[0]);		
		System.out.println("Segundo N�mero Digitado: "+numero[1]);
		System.out.println("Terceiro N�mero Digitado: "+numero[2]);
		System.out.println("Quarto N�mero Digitado: "+numero[3]);
		System.out.println("Quinto N�mero Digitado: "+numero[4]);
		
		
	}

}
