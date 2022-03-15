package di.pizzaria.service;

public class PedidoService {

    private PizzaService pizzaService;
    
    public PedidoService(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }
    
    public void fazerPedido() {
        System.out.println("\nFazer pedido de Pizza.");
        pizzaService.prepararPizza();
    }
    
}
