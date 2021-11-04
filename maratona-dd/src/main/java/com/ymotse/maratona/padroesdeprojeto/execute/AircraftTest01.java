package com.ymotse.maratona.padroesdeprojeto.execute;

import com.ymotse.maratona.padroesdeprojeto.dominio.Aircraft;
import com.ymotse.maratona.padroesdeprojeto.dominio.AircraftSingletonEager;

public class AircraftTest01 {

    public static void main(String[] args) {
        bookSeat("1A");
        bookSeat("1A");
    }

    static void bookSeat(String seat) {
        System.out.println(AircraftSingletonEager.getINSTANCE());
//        Aircraft aircraft = new Aircraft("787-900");
//        System.out.println(aircraft.bookSeat(seat));
    }

}
