package estudos;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataDeOntem {

	public static void main(String[] args) {
				
		Calendar calendar = Calendar.getInstance(); 
		calendar.add(Calendar.DATE, -1); 
		SimpleDateFormat tesedata = new SimpleDateFormat("yyyy-MM-dd"); 
		System.out.println(tesedata.format(calendar.getTime())); 
	}

}
