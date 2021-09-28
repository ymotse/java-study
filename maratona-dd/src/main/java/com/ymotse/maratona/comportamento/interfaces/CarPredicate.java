package com.ymotse.maratona.comportamento.interfaces;

import com.ymotse.maratona.comportamento.dominio.Car;

public interface CarPredicate {

    boolean test(Car car);
}
