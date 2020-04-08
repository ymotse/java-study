package lambdas;

public class Paralelismo {
	
	public static void main(String[] args) {
		
		Runnable trabalho1 = () -> {
			for(int i = 0; i < 10; i++) {
				System.out.println("Tarefa #01: " + i);
				
				try {
					Thread.sleep(100);
				} catch(Exception e) {}
			}
		};

		Runnable trabalho2 = Paralelismo::trabalho;
		
		Thread t1 = new Thread(trabalho1);
		Thread t2 = new Thread(trabalho2);
		
		t1.start();
		t2.start();
		
	}
	
	static void trabalho() {
		for(int i = 0; i < 10; i++) {
			System.out.println("Tarefa #02: " + i);
			
			try {
				Thread.sleep(100);
			} catch(Exception e) {}
		}
	}
	
}
