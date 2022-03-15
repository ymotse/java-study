package di.pizzaria.business;

import di.pizzaria.service.PizzaService;

public class Queijo implements PizzaService {

    @Override
    public void prepararPizza() {
        System.out.println("Preparacao da Pizza de Queijo...");
    }

}
