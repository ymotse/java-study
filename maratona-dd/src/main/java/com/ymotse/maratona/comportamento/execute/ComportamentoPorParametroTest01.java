package com.ymotse.maratona.comportamento.execute;

import com.ymotse.maratona.comportamento.dominio.Car;
import com.ymotse.maratona.comportamento.interfaces.CarPredicate;

import java.util.ArrayList;
import java.util.List;

public class ComportamentoPorParametroTest01 {

    private static List<Car> cars = List.of(
            new Car("green", 2011),
            new Car("black", 1998),
            new Car("red", 2019)
    );

    public static void main(String[] args) {
        List<Car> greenCars = filter(cars, new CarPredicate() {
            @Override
            public boolean test(Car car) {
                return car.getColor().equals("green");
            }
        });

        List<Car> yearBeforeCars = filter(cars, new CarPredicate() {
            @Override
            public boolean test(Car car) {
                return car.getYear() < 2015;
            }
        });

        System.out.println(greenCars);
        System.out.println(yearBeforeCars);

        System.out.println("---------------");

        System.out.println(filter(cars, (Car car) -> car.getColor().equals("black")));;
        System.out.println(filter(cars, (Car car) -> car.getColor().equals("red")));;
    }

    private static List<Car> filter(List<Car> cars, CarPredicate carPredicate) {
        List<Car> filteredCars = new ArrayList<>();
        for (Car car : cars) {
            if(carPredicate.test(car)) {
                filteredCars.add(car);
            }
        }
        return filteredCars;
    }

}
