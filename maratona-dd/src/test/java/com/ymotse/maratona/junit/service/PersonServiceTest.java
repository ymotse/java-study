package com.ymotse.maratona.junit.service;

import com.ymotse.maratona.junit.dominio.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class PersonServiceTest {

    private Person adult;
    private Person notAdult;
    private PersonService personService;

    @BeforeEach
    public void setUp() {
        adult = new Person(18);
        notAdult = new Person(15);
        personService = new PersonService();
    }

    @Test
    @DisplayName("A person should be not adult when age is lower than 18")
    void isAdult_ReturnFalse_WhenAgeIsLowerThan18() {
//        Assertions.assertEquals(false, personService.isAdult(notAdult));
        Assertions.assertFalse(personService.isAdult(notAdult));
    }

    @Test
    @DisplayName("A person should be adult when age is greater or than 18")
    void isAdult_ReturnTrue_WhenAgeIsGreaterOrThan18() {
//        Assertions.assertEquals(true, personService.isAdult(adult));
        Assertions.assertTrue(personService.isAdult(adult));
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException with message when person is null")
    void isAdult_ThrowException_WhenPersonIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> personService.isAdult(null));
    }

    @Test
    @DisplayName("Should return list with only adults")
    void filterRemovingNotAdult_ReturnListWithAdultOnly_WhenListOfPersonWithAdultIsPassed() {
        List<Person> personList = List.of(new Person(17), new Person(18), new Person(21));

        Assertions.assertEquals(2, personService.filterRemovingNotAdult(personList).size());
    }

}