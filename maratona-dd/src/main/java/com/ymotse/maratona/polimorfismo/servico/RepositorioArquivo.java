package com.ymotse.maratona.polimorfismo.servico;

import com.ymotse.maratona.polimorfismo.repositorio.Repositorio;

public class RepositorioArquivo implements Repositorio {

    @Override
    public void salvar() {
        System.out.println("Salvando no Arquivo");
    }
}
