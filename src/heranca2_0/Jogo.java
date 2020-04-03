package heranca2_0;

public class Jogo {
	
	public static void main(String[] args) {
		
		
		
		Monstro monstro = new Monstro();
		monstro.x = 10;
		monstro.y = 10;
		
		Heroi heroi = new Heroi(10, 11);
		
		System.out.println("Monstro: " + monstro.vida);
		System.out.println("heroi: " + heroi.vida);
		
		monstro.atacar(heroi);
		heroi.atacar(monstro);
		
		System.out.println("Monstro: " + monstro.vida);
		System.out.println("heroi: " + heroi.vida);
		
		monstro.andar(Direcao.NORTE);
		monstro.andar(Direcao.LESTE);
		monstro.andar(Direcao.NORTE);
		monstro.andar(Direcao.LESTE);
		
		System.out.println(monstro.x);
		System.out.println(monstro.y);
	}
	
}
