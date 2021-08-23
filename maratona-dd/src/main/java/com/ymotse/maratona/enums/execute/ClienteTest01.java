package com.ymotse.maratona.enums.execute;

import com.ymotse.maratona.enums.dominio.Cliente;
import com.ymotse.maratona.enums.dominio.TipoCliente;

public class ClienteTest01 {

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Buma", TipoCliente.PESSOA_FISICA);
        Cliente cliente2 = new Cliente("Mestre Kame", TipoCliente.PESSOA_JURIDICA);
        Cliente cliente3 = new Cliente("Goku", TipoCliente.PESSOA_FISICA);
        Cliente cliente4 = new Cliente("Kuririn", TipoCliente.PESSOA_JURIDICA);

        System.out.println(cliente1);
        System.out.println(cliente2);
        System.out.println(cliente3);
        System.out.println(cliente4);
    }

}
