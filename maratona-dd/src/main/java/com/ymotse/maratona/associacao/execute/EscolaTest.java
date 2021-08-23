package com.ymotse.maratona.associacao.execute;

import com.ymotse.maratona.associacao.dominio.Escola;
import com.ymotse.maratona.associacao.dominio.Professor;

public class EscolaTest {

    public static void main(String[] args) {
        Professor profZezinho = new Professor("José");
        Professor profMaria = new Professor("Ana Maria");
        Professor[] professores = { profZezinho, profMaria };

        Escola escola = new Escola("Konoha", professores);

        escola.imprimir();
    }

}
