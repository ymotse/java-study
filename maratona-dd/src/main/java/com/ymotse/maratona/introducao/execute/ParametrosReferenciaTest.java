package com.ymotse.maratona.introducao.execute;

import com.ymotse.maratona.introducao.dominio.Estudante;
import com.ymotse.maratona.introducao.dominio.ImpressoraEstudante;

public class ParametrosReferenciaTest {

    public static void main(String[] args) {

        Estudante estudante1 = new Estudante();
        estudante1.nome = "Gohan";
        estudante1.sexo = 'M';
        estudante1.idade = 16;

        ImpressoraEstudante impressoraEstudante = new ImpressoraEstudante();
        impressoraEstudante.imprimir(estudante1);

        /* Impresso valor modificado pelo metodo imprimir() */
        System.out.println(estudante1.toString());
    }

}
