package estudos;

import java.util.Calendar; 

public class Data_Calendar_Get{ 

	public static void main(String[] args) {
		
		Calendar c = Calendar.getInstance();
		System.out.println("Data/Hora atual: "+c.getTime());
		System.out.println("Ano: "+c.get(Calendar.YEAR));
		System.out.println("M�s: "+c.get(Calendar.MONTH));
		System.out.println("Dia: "+c.get(Calendar.DAY_OF_MONTH));
		
		System.out.println("\nHora: "+c.get(Calendar.HOUR_OF_DAY));
		System.out.println("Minuto: "+c.get(Calendar.MINUTE));
		System.out.println("Segundo: "+c.get(Calendar.SECOND));
		}
	
	}
