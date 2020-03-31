package estudos;

public class Metodo_sem_Parametro {

	String Nome;
	int ID, n1,n2,result;
	double media;
	
		void exibir() {
			System.out.println("Bem Vindo "+Nome+", Seu ID eh "+ID);
		}
	
			void exibirSoma(){
			result = n1 + n2;
			System.out.println("A soma de "+n1+"+"+n2+"="+result);
			}
		
				void exibirMedia(){
				media = (result)/2;
				System.out.println("M�dia: "+media);
				}

	public static void main(String[] args) {
		Metodo_sem_Parametro conta = new Metodo_sem_Parametro();
		conta.Nome = "Usuario";
		conta.ID = 12;
		conta.exibir();
		conta.n1 = 3;
		conta.n2 = 5;
		conta.exibirSoma();
		conta.exibirMedia();
	}

}
