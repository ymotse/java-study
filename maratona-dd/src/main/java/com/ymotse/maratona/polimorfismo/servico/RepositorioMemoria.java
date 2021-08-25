package com.ymotse.maratona.polimorfismo.servico;

import com.ymotse.maratona.polimorfismo.repositorio.Repositorio;

public class RepositorioMemoria implements Repositorio {

    @Override
    public void salvar() {
        System.out.println("Salvando na Memoria");
    }
}
