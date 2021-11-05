package com.ymotse.maratona.padroesdeprojeto.execute;

import com.ymotse.maratona.padroesdeprojeto.dominio.AircraftSingletonEnum;

public class AircraftSingletonEnumTest01 {

    public static void main(String[] args) {
        bookSeat("1A");
        bookSeat("1A");
    }

    private static void bookSeat(String seat) {
        AircraftSingletonEnum instance = AircraftSingletonEnum.INSTANCE;
        System.out.println(instance.hashCode());
        System.out.println(instance.bookSeat(seat));
    }

}
