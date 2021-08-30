package com.ymotse.maratona.dates.execute;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class LocalDateTimeTest01 {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        System.out.println(now.getYear());
        System.out.println(now.getMonth());
        System.out.println(now.getDayOfMonth());
        System.out.println(now.getHour());
        System.out.println(now.getMinute());
        System.out.println(now.getSecond());
        System.out.println("-------------------");

        LocalDate date = LocalDate.of(2022, Month.AUGUST, 6);
        LocalDate date2 = LocalDate.parse("2022-08-06");
        LocalTime time = LocalTime.of(9, 45, 21);
        LocalTime time2 = LocalTime.parse("09:45:21");

        System.out.println(date);
        System.out.println(date2);
        System.out.println(time);
        System.out.println(time2);
        System.out.println("-------------------");

        LocalDateTime localDateTime1 = date.atTime(time);
        LocalDateTime localDateTime2 = time.atDate(date);
        System.out.println(localDateTime1);
        System.out.println(localDateTime2);



    }

}
