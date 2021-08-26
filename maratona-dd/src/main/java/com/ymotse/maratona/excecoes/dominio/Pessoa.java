package com.ymotse.maratona.excecoes.dominio;

import java.io.FileNotFoundException;

public class Pessoa {

    public void salvar() throws LoginInvalidoException, FileNotFoundException {
        System.out.println("Salvando Pessoa");
    }

}
