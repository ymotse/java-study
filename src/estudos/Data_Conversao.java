package estudos;


import java.util.Calendar;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

	public class Data_Conversao {
		
		public static void main(String[] args) throws ParseException {
			
			
			DateFormat f = DateFormat.getDateInstance();
			Date data2 = f.parse("12/01/1995");
			System.out.println(data2);
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Calendar c = Calendar.getInstance();
			Date data = c.getTime();
			System.out.println("Data formatada: "+sdf.format(data));
			
			//Converte Objetos
			System.out.println("Data convertida: "+sdf.parse("02/08/1970"));

		}
		
	}

