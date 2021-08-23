package com.ymotse.maratona.associacao.execute;

import com.ymotse.maratona.associacao.dominio.Jogador;
import com.ymotse.maratona.associacao.dominio.Time;

public class JogadorTest {

    public static void main(String[] args) {
        Jogador pele = new Jogador("Pelé");
        Time santos = new Time("Santos");

        pele.setTime(santos);
        pele.imprimir();

        // ------------------------------------------------------------
        Jogador jogador1 = new Jogador("Cafu");
        Jogador jogador2 = new Jogador("Ronaldo");
        Time time = new Time("Brasil");
        Jogador[] jogadores = { jogador1, jogador2 };

        jogador1.setTime(time);
        jogador2.setTime(time);
        time.setJogadores(jogadores);

        System.out.println("--- Jogador ---");
        jogador1.imprimir();
        jogador2.imprimir();

        System.out.println("--- Time ---");
        time.imprimir();
    }

}
