package com.ymotse.maratona.associacao.execute;

import com.ymotse.maratona.associacao.dominio.Jogador;
import com.ymotse.maratona.associacao.dominio.Time;

public class JogadorTest {

    public static void main(String[] args) {
        Jogador pele = new Jogador("Pelé");
        Time santos = new Time("Santos");

        pele.setTime(santos);
        pele.imprimir();
    }

}
