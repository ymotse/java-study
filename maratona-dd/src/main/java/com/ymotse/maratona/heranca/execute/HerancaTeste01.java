package com.ymotse.maratona.heranca.execute;

import com.ymotse.maratona.heranca.dominio.Endereco;
import com.ymotse.maratona.heranca.dominio.Funcionario;

public class HerancaTeste01 {

    public static void main(String[] args) {
        Endereco endereco = new Endereco("Rua 3", "012345-420");

        Funcionario funcionario = new Funcionario("Vegeta");
        funcionario.setCpf("123.456.789-00");
        funcionario.setEndereco(endereco);
        funcionario.setSalario(10000.00);
        funcionario.imprimir();
    }

}
