package heranca.heranca_filhos;

public class Carro_Teste {

	public static void main(String[] args) {
		
		Carro c = new Carro();
		c.dono = "Yitshhaq";
		c.marca = "Volkswagen";
		c.qtd_rodas = 4;
		
		c.cambio = "automatico";
		
		
		System.out.println(c.acelerar());
		
		System.out.println(c.frear());
		
		
	}

}
