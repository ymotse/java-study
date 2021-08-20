package com.ymotse.maratona.associacao.execute;

import com.ymotse.maratona.associacao.dominio.Jogador;

public class JogadorTest {

    public static void main(String[] args) {
        Jogador pele = new Jogador("Pelé");
        Jogador romario = new Jogador("Romário");
        Jogador cafu = new Jogador("Cafu");

        Jogador[] jogadores = { pele, romario, cafu };

        for (Jogador jogador: jogadores) {
            jogador.imprimir();
        }
    }
    
}
