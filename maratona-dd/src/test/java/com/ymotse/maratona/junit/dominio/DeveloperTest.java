package com.ymotse.maratona.junit.dominio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DeveloperTest {

    @Test
    public void instanceOf_ExecutesChildClassMethod_WhenObjectIsOfChildType() {
        Employee employeeDeveloper = new Developer("1", "Java");

        //Modo antigo:
        if(employeeDeveloper instanceof Developer) {
            Developer developer = (Developer) employeeDeveloper;
            Assertions.assertEquals("Java", developer.getMainLanguage());
        }

        // Pattern Matching:
        if(employeeDeveloper instanceof Developer developer) {
            Assertions.assertEquals("Java", developer.getMainLanguage());
        }
    }
}