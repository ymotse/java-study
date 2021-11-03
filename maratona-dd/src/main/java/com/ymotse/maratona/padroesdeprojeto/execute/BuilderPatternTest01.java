package com.ymotse.maratona.padroesdeprojeto.execute;

import com.ymotse.maratona.padroesdeprojeto.dominio.Person;

public class BuilderPatternTest01 {

    public static void main(String[] args) {
        Person person = Person.PersonBuilder.builder()
                .firstName("John")
                .lastName("Scott")
                .username("johnScott")
                .email("jscott@mail.com")
                .build();

        System.out.println(person);
    }

}
