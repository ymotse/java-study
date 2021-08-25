package com.ymotse.maratona.polimorfismo.execute;

import com.ymotse.maratona.polimorfismo.repositorio.Repositorio;
import com.ymotse.maratona.polimorfismo.servico.RepositorioArquivo;
import com.ymotse.maratona.polimorfismo.servico.RepositorioBancoDeDados;
import com.ymotse.maratona.polimorfismo.servico.RepositorioMemoria;

public class RepositorioTest {

    public static void main(String[] args) {
        Repositorio repositorio = new RepositorioBancoDeDados();
        repositorio.salvar();

        repositorio = new RepositorioArquivo();
        repositorio.salvar();

        repositorio = new RepositorioMemoria();
        repositorio.salvar();
    }

}
