package estudos;

import java.util.Calendar;

public class Data_Calendar_Set{

	public static void main(String[] args) {
		
		Calendar c = Calendar.getInstance();
		
		c.set(Calendar.YEAR, 1995);
		c.set(Calendar.MONTH, Calendar.MARCH);
		c.set(Calendar.DAY_OF_MONTH, 20);
		
		System.out.println("Data/Hora atual: "+c.getTime());
		System.out.println("Ano: "+c.get(Calendar.YEAR));
		System.out.println("M�s: "+c.get(Calendar.MONTH));
		System.out.println("Dia: "+c.get(Calendar.DAY_OF_MONTH));
		
		}
	}

