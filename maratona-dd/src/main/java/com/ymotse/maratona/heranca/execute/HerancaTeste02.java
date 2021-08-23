package com.ymotse.maratona.heranca.execute;

import com.ymotse.maratona.heranca.dominio.Funcionario;

public class HerancaTeste02 {

    /**
     * 0 - Bloco de Inicializacao estatico da super-classe eh executado quando a JVM carregar classe pai.
     * 1 - Bloco de Inicializacao estatico da sub-classe eh executado quando a JVM carregar classe filha.
     * 2 - Alocado espaco em memoria para objeto da super-classe.
     * 3 - Cada atributo de super-classe eh criado e inicializado com valores default ou o quer for passado.
     * 4 - Bloco de Inicializacao da super-classe eh executado na ordem em que aparece.
     * 5 - Construtor da super-classe eh executado.
     * 6 - Alocado espaco em memoria para objeto da sub-classe.
     * 7 - Cada atributo de sub-classe eh criado e inicializado com valores default ou o quer for passado.
     * 8 - Bloco de Inicializacao da sub-classe eh executado na ordem em que aparece.
     * 9 - Construtor da sub-classe eh executado.
     */
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario("Jiraya");
    }

}
