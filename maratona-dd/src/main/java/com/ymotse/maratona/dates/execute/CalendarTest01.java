package com.ymotse.maratona.dates.execute;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest01 {

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        Date date = c.getTime();
        System.out.println(date);
        System.out.println(c);

        if(c.getFirstDayOfWeek() == Calendar.SUNDAY) {
            System.out.println("Domingao eh o primeiro dia da semana");
        }

        System.out.println(c.get(Calendar.MONTH)); // 0 - 11
        System.out.println(c.get(Calendar.DAY_OF_MONTH));
        System.out.println(c.get(Calendar.DAY_OF_WEEK));
        System.out.println(c.get(Calendar.DAY_OF_YEAR));

        c.add(Calendar.DAY_OF_MONTH, 2);
        c.add(Calendar.HOUR, 2);

        System.out.println(c.getTime());
    }

}
