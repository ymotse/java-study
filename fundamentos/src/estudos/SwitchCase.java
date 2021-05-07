package estudos;
import java.util.Scanner;
public class SwitchCase {
public static void main (String []args){
 
int DiaDaSemana;
 
System.out.println("De 1 a 7, Digite um n�mero para o dia da semana:");
@SuppressWarnings("resource")
Scanner imprimi = new Scanner (System.in); 
DiaDaSemana = imprimi.nextInt();
 
switch(DiaDaSemana){

case 1:
 System.out.println("Segunda-feira");
break;

case 2:
 System.out.println("Ter�a-feira");
break;
 
case 3:
 System.out.println("Quarta-feira");
break;
 
case 4:
 System.out.println("Quinta-feira");
break;
 
case 5:
 System.out.println("Sexta-feira");
break;
 
case 6:
 System.out.println("S�bado");
break;
 
case 7:
 System.out.println("Domingo");
break;
 
default:
 System.out.println("Dia da semana invalido!"); 
		} 
	}
 }