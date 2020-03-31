package estudos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataComIfElse {

	public static void main(String[] args) throws ParseException {

	    try {
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    	Date date1 = sdf.parse("2015-11-02");
	    	Date date2 = sdf.parse("2015-11-02");

	    	System.out.println("Data 1: "+sdf.format(date1));
	    	System.out.println("Data 2: "+sdf.format(date2) +"\n");
    	
	    	if(date1.compareTo(date2)>0){ // Maior que 0, se Data for depois que Data do Argumento.
	    		System.out.println("Data 1 é depois de Data 2.");
	    	} else if(date1.compareTo(date2)<0){ // Menor que 0, se Data for antes que Data do Argumento.
	    		System.out.println("Data 1 é antes de Data 2.");
	    	} else if(date1.compareTo(date2)==0){ // Igual a 0 se as datas forem iguais.
	    		System.out.println("Data 1 é igual a Data 2.");
	    	} else {
	    		System.out.println("How to get here?");
	    	}
	    } catch(ParseException ex){
	    	ex.printStackTrace();
	    }
	
	}
	
}
