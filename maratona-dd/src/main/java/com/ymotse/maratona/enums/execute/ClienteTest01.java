package com.ymotse.maratona.enums.execute;

import com.ymotse.maratona.enums.dominio.Cliente;
import com.ymotse.maratona.enums.dominio.TipoCliente;

public class ClienteTest01 {

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Buma", TipoCliente.PESSOA_FISICA, Cliente.TipoPagamento.DEBITO);
        Cliente cliente2 = new Cliente("Mestre Kame", TipoCliente.PESSOA_JURIDICA, Cliente.TipoPagamento.CREDITO);

        System.out.println(cliente1);
        System.out.println(cliente2);
    }

}
