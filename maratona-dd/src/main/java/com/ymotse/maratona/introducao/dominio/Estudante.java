package com.ymotse.maratona.introducao.dominio;

public class Estudante {

    public String nome = "Zorro";
    public int idade;
    public char sexo;

    @Override
    public String toString() {
        return "Estudante{" +
                "\n   nome='" + nome + '\'' +
                "\n   , idade=" + idade +
                "\n   , sexo=" + sexo +
                "'\n}'";
    }

}
