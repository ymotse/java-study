package com.ymotse.maratona.dates.execute;

import java.time.LocalDate;
import java.time.Period;

public class PeriodTest01 {

    public static void main(String[] args) {
        Period p1 = Period.between(LocalDate.now(), LocalDate.now().plusWeeks(1));
        Period p2 = Period.between(LocalDate.now(), LocalDate.now().plusYears(2));
        Period p3 = Period.ofDays(50);
        Period p4 = Period.ofWeeks(58);
        Period p5 = Period.ofMonths(3);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);
    }

}
