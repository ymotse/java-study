package estudos;

import javax.swing.JOptionPane;

public class Dialog {
	
	
	public static void main(String[] args) {
		
		String nome = JOptionPane.showInputDialog("Digite seu nome:");
		System.out.println(nome);
		
		JOptionPane.showMessageDialog(null, "Bem vindo "+nome);
	}
	
}
