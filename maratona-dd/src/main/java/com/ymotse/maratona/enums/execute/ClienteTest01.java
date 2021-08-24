package com.ymotse.maratona.enums.execute;

import com.ymotse.maratona.enums.dominio.Cliente;
import com.ymotse.maratona.enums.dominio.TipoCliente;
import com.ymotse.maratona.enums.dominio.TipoPagamento;

public class ClienteTest01 {

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Buma", TipoCliente.PESSOA_FISICA, TipoPagamento.DEBITO);
        Cliente cliente2 = new Cliente("Mestre Kame", TipoCliente.PESSOA_JURIDICA, TipoPagamento.CREDITO);

        System.out.println(cliente1);
        System.out.println(cliente2);

        System.out.println(TipoPagamento.DEBITO.CalcularDesconto(100));
        System.out.println(TipoPagamento.CREDITO.CalcularDesconto(100));

        TipoCliente tipoCliente = TipoCliente.valueOf("PESSOA_FISICA");
        System.out.println(tipoCliente.getNomeRelatorio());

        TipoCliente tipoCliente2 = TipoCliente.tipoClientePorNomeRelatorio("Pessoa Física");
        System.out.println(tipoCliente2);

    }

}
