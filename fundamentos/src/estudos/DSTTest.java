package estudos;

/*
* Timezone test to check that the new US 2007 DST rules have been
* picked up by the JRE. TimeZone used is the default one on OS.
* Sample result :
* $java DSTTest "11/04/2007 0:00 AM"
* JRE version : 1.4.2_13
* Sun Nov 04 00:00:00 EDT 2007
* TimeZone tested : Eastern Daylight Time
* Your tested time is in daylight-savings time.
* $java DSTTest "11/04/2007 3:00 AM"
* JRE version : 1.4.2_13
* Sun Nov 04 03:00:00 EST 2007
* TimeZone tested : Eastern Standard Time
* Your tested time is not in daylight-savings time.
* $echo $TZ
* America/New_York
*
*/
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.joda.time.LocalTime;
public class DSTTest {
	
	public static void main(String[] args) {
		
		try {
		
			Date data = new Date();  

			SimpleDateFormat formatador = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
			
			String dataAtual = formatador.format( data ); 
			System.out.println("Data/Hora do Host: "+dataAtual);
			
			Date currentDate = formatador.parse(dataAtual); //Recebe data formatada.
			TimeZone tz = TimeZone.getDefault(); //Pega o TimeZone que o sistema esta sendo usado.

			boolean indaylight = tz.inDaylightTime(currentDate); 
			//System.out.println(indaylight); // 0(False) nao esta | 1(True) esta
			System.out.println("Data " + (indaylight ? "EST� dentro do " : "NAO ESTA dentro do ") + "Horario de Verao Brasileiro.");
			System.out.println(new java.util.Date());

		} catch (Exception e) {
			System.out.println("Errorutered. Please insure you supply a valid date format pattern.");
			System.out.println("Ensureve quotes placed around the pattern!");
			System.out.println("e.g DSTTest \"11/04/2007 1:00 AM\"");
		}
		

        
        Locale locale = new Locale("pt", "BR");
        Calendar dateBeginLY = Calendar.getInstance();
        LocalTime jodaHourBegin = new LocalTime(dateBeginLY.getTime());
       
        System.out.println("---------------------------------------------------------------");
        System.out.println(dateBeginLY);
        System.out.println(dateBeginLY.toString());
        System.out.println("---------------------------------------------------------------");
        System.out.println(jodaHourBegin);
        System.out.println("Hora:   "+jodaHourBegin.getHourOfDay());
        System.out.println("Minuto: "+jodaHourBegin.toDateTimeToday().getMinuteOfHour());
        System.out.println("Segundo:"+jodaHourBegin.toDateTimeToday().getSecondOfMinute());
        System.out.println(jodaHourBegin.toString("HH:mm:ss", locale));
        System.out.println(jodaHourBegin.getChronology());
        
        System.out.println("---------------------------------------------------------------");
        @SuppressWarnings("deprecation")
		LocalTime jodaHour = new LocalTime(dateBeginLY.getTime().getHours(),dateBeginLY.getTime().getMinutes(),dateBeginLY.getTime().getSeconds());
        System.out.println(jodaHour + " <- Usando LocalTime");
        
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date calendar2 = Calendar.getInstance().getTime();
        System.out.println(sdf.format(calendar2) + "     <- Usando SimpleDateFormat");
        
        Calendar calendar = Calendar.getInstance();
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);
        System.out.println(hours+":"+minutes+":"+seconds + "     <- Usando Calendar");
        System.out.println("---------------------------------------------------------------");
		

//        LocalTime jodaHour2 = new LocalTime(hours,minutes,seconds);
//        System.out.println(jodaHour2);
        
	}
}