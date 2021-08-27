package com.ymotse.maratona.dates.execute;

import java.util.Date;

public class DateTest01 {

    public static void main(String[] args) {
        Date date = new Date(); //long 1970-01-01
        date.setTime(date.getTime() + 3_600_000);
        System.out.println(date);
    }

}
