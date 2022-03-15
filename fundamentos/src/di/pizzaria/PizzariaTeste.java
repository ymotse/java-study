package di.pizzaria;

import di.pizzaria.business.Calabresa;
import di.pizzaria.business.Queijo;
import di.pizzaria.service.PedidoService;

public class PizzariaTeste {
    
    public static void main(String[] args) {
        
        PedidoService pedidoCalabresa = new PedidoService(new Calabresa());
        pedidoCalabresa.fazerPedido();
        
        PedidoService pedidoQueijo = new PedidoService(new Queijo());
        pedidoQueijo.fazerPedido();
        
    }

}
