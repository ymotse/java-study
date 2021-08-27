package com.ymotse.maratona.dates.execute;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class LocaleTest01 {

    public static void main(String[] args) {
        // pt-BR
        Locale localeItaly = new Locale("it", "IT");
        Locale localeSuica = new Locale("it", "CH");
        Locale localeIndia = new Locale("hi", "IN");
        Locale localeJapao = new Locale("ja", "JP");
        Locale localeHolanda = new Locale("nl", "NL");


        Calendar c = Calendar.getInstance();
        DateFormat dfItalia = DateFormat.getDateInstance(DateFormat.FULL, localeItaly);
        DateFormat dfSuica = DateFormat.getDateInstance(DateFormat.FULL, localeSuica);
        DateFormat dfIndia = DateFormat.getDateInstance(DateFormat.FULL, localeIndia);
        DateFormat dfJapao = DateFormat.getDateInstance(DateFormat.FULL, localeJapao);
        DateFormat dfHolanda = DateFormat.getDateInstance(DateFormat.FULL, localeHolanda);

        System.out.println("Italia : " + dfItalia.format(c.getTime()));
        System.out.println("Suica  : " + dfSuica.format(c.getTime()));
        System.out.println("India  : " + dfIndia.format(c.getTime()));
        System.out.println("Japao  : " + dfJapao.format(c.getTime()));
        System.out.println("Holanda: " + dfHolanda.format(c.getTime()));

        System.out.println(localeHolanda.getDisplayCountry(localeHolanda));
    }

}
