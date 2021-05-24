package com.example;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.example.model.Contact;

import lombok.Data;

@Data
public class ContactCreator {
    
    static DateFormat birthDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static Contact createContactToBeSaved() throws ParseException {
        
        return Contact.builder()
                .name("John")
                .birthDate(birthDateFormat.parse("01/01/2000"))
                .email("john@mail.com")
                .build();
    }
    
    public static Contact createContactToBeValidate() throws ParseException {
        return Contact.builder()
                .id(1L)
                .name("John")
                .birthDate(birthDateFormat.parse("01/01/2000"))
                .email("john@mail.com")
                .build();
    }
}
