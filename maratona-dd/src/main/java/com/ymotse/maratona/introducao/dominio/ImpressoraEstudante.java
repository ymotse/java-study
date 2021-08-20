package com.ymotse.maratona.introducao.dominio;

public class ImpressoraEstudante {

    public void imprimir(Estudante estudante) {
        System.out.println("----- imprimir Estudante");
        System.out.println(estudante.toString());
        System.out.println("-----\n");

        /**
         * Por boas práticas e segurança, não é recomendado manipular
         * o valor do parametro de referencia; e sim clonar o mesmo
         * para outro objeto e retornar um novo objeto.
         */
        estudante.nome = "Parametro de referencia: Cuidado! O Atributo do objeto original foi alterado.";
    }

}
