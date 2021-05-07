// TABUADA UTILIZANDO O "FOR", "JOPTIONPANE" E "VETOR"

package estudos;

import javax.swing.JOptionPane;

public class For_e_JOptionPane {
public static void main (String[]args){
	
	int i,digitado;
	int vetor[] = new int[11];	
	
JOptionPane.showMessageDialog(null,"Tabuada de qualquer n�mero, \n"+"Basta digitar um numero",
		"Tabuada!!!",JOptionPane.INFORMATION_MESSAGE);
	
digitado = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite um n�mero qualquer:","Tabuada:",JOptionPane.QUESTION_MESSAGE));


	for(i = 1; i <= 10; i++)
	{
		vetor[i] = i;

	int result = digitado * vetor[i];
		
JOptionPane.showMessageDialog(null,digitado+" x "+vetor[i]+" = "+result,"Resultado da Tabuada do "+digitado, JOptionPane.INFORMATION_MESSAGE);
	}}} 