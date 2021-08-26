package com.ymotse.maratona.excecoes.execute;

import com.ymotse.maratona.excecoes.dominio.Funcionario;
import com.ymotse.maratona.excecoes.dominio.LoginInvalidoException;
import com.ymotse.maratona.excecoes.dominio.Pessoa;

public class SobrescritaComExceptionTest01 {

    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        Funcionario funcionario = new Funcionario();

        try {
            funcionario.salvar();
        } catch (LoginInvalidoException e) {
            e.printStackTrace();
        }
    }

}
