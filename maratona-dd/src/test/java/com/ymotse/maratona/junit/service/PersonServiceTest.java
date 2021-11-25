package com.ymotse.maratona.junit.service;

import com.ymotse.maratona.junit.dominio.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PersonServiceTest {

    @Test
    @DisplayName("A person should be not adult when age is lower than 18")
    void isAdult_ReturnFalse_WhenAgeIsLowerThan18() {
        Person person = new Person(15);
        PersonService personService = new PersonService();

//        Assertions.assertEquals(false, personService.isAdult(person));
        Assertions.assertFalse(personService.isAdult(person));
    }
}