package estudos;

public class Metodo_com_Parametro {

	double saldo, valor;
	
	void exibirSaldo(){
		System.out.println("Seu Saldo: "+saldo);
	}
	
	void saca (double valor){ 		// ISSO Eh UM M�TODO COM PARAMETRO
		saldo -= valor;
		//  saldo = saldo - valor;
	}
	
	public static void main(String[] args) {
		Metodo_com_Parametro Objeto = new Metodo_com_Parametro();
		Objeto.saldo= 10_000.00;
		Objeto.exibirSaldo();
		
		Objeto.valor = 1_000.00;
		Objeto.saca(1000);
		Objeto.exibirSaldo();

	}

}
