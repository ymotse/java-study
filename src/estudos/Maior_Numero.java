package estudos;
import javax.swing.JOptionPane;

public class Maior_Numero{
public static void main(String[]args){
	
int maior = 0; 

int p1 , p2 , p3;


	p1 = Integer.parseInt(JOptionPane.showInputDialog(null,"1.Digite sua idade:","TITULO - CAIXA 1",JOptionPane.QUESTION_MESSAGE));
	if (p1 > maior){
		maior = p1;
}
	p2 = Integer.parseInt(JOptionPane.showInputDialog(null,"2.Digite sua idade:","TITULO - CAIXA 2",JOptionPane.QUESTION_MESSAGE));
	if (p2 > maior){
		maior = p2;
}
	p3 = Integer.parseInt(JOptionPane.showInputDialog(null,"3.Digite sua idade:","TITULO - CAIXA 3",JOptionPane.QUESTION_MESSAGE));
	if (p3 > maior){
		maior = p3;
}		
		JOptionPane.showMessageDialog(null, maior,"TITULO - MAIOR N�MERO",JOptionPane.INFORMATION_MESSAGE);
	


}
}
