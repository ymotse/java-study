package estudos;

public class Poupanca {

	String cliente; int ID; double saldo,saca,depositado;
	
	void exibeSaldo() {
	System.out.println("Cliente "+cliente+", ID:"+ID+". Seu saldo eh de "+saldo);	}

	void exibeNovoSaldo(){
		saldo -=saca;
		System.out.println("Cliente "+cliente+", ID:"+ID+". Seu novo saldo eh de "+saldo); }
		
	void exibeSaque(){
		System.out.println("Cliente "+cliente+", ID:"+ID+". Voce sacou "+saca);	}
	
	void exibeDeposito(){
		saldo +=depositado;
		System.out.println("Cliente "+cliente+", ID:"+ID+". Foi depositado "+depositado);	}
	
	
	public static void main(String[] args) {
		Poupanca conta = new Poupanca();
		conta.cliente = "Isac";
		conta.ID = 20;
		conta.saldo = 1_000;
		
		conta.exibeSaldo();
		conta.saca = 100;
		conta.exibeSaque();
		conta.exibeNovoSaldo();
		conta.depositado = 200;
		conta.exibeDeposito();
		conta.exibeSaldo();
		
		}	 //fechando o metodo principal
	} //fechando a classe
		
	


