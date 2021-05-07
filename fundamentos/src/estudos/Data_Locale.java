package estudos;


import java.util.Calendar;
import java.util.Locale;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class Data_Locale { 
	
	public static void main(String[] args) throws ParseException {
		
		Calendar c = Calendar.getInstance();
		Date data = c.getTime();
		Locale brasil = new Locale("pt", "BR");
		
		//Retorna do paes e a lingua 
		Locale eua = Locale.US;
		Locale italia = Locale.ITALIAN;
		
		DateFormat f2 = DateFormat.getDateInstance(DateFormat.FULL, brasil);
		System.out.println("Data e hora brasileira: "+f2.format(data));
		
		DateFormat f3 = DateFormat.getDateInstance(DateFormat.FULL, eua);
		System.out.println("Data e hora americana: "+f3.format(data));
		
		DateFormat f4 = DateFormat.getDateInstance(DateFormat.FULL, italia);
		System.out.println("Data e hora italiana: "+f4.format(data));

	}
	
}

