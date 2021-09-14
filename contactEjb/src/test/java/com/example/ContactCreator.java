package com.example;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.model.Contact;

import lombok.Data;

@Data
public class ContactCreator {
    
    static DateFormat birthDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static Contact createContactToBeSaved() throws ParseException {
        
        return Contact.builder()
                .name("John")
                .birthDate(birthDateFormat.parse("29/02/2020"))
                .email("john@mail.com")
                .build();
    }
    
    public static Contact createContactToBeValidate() throws ParseException {
        return Contact.builder()
                .id(1L)
                .name("John")
                .birthDate(birthDateFormat.parse("29/02/2020"))
                .email("john@mail.com")
                .build();
    }
    
    public static List<Object[]> createObjectContactInList() throws Exception {
        List<Object[]> objectContacts = new ArrayList<Object[]>();
        
        objectContacts.add(new Object[] { 1L, "John", "29/02/2020", "john@mail.com" });

        return objectContacts;
    }

    public static List<Contact> createContactInListToBeValidate() throws Exception {
        return Arrays.asList(
                Contact.builder()
                    .id(1L)
                    .name("John")
                    .email("john@mail.com")
                    .birthDate(birthDateFormat.parse("29/02/2020"))
                    .build()
            );
    }
    
    public static List<Object[]> createTwoObjectContactsInList() throws Exception {
        List<Object[]> objectContacts = new ArrayList<Object[]>();
        
        objectContacts.add(new Object[] { 1L, "John", "29/02/2020", "john@mail.com" });
        objectContacts.add(new Object[] { 2L, "John 2", "28/02/2021", null });

        return objectContacts;
    }

    public static List<Contact> createTwoContactsInListToBeValidate() throws Exception {
        return new ArrayList<Contact>(
                Arrays.asList(
                    Contact.builder().id(1L).name("John").birthDate(birthDateFormat.parse("29/02/2020")).email("john@mail.com").build(),
                    Contact.builder().id(2L).name("John 2").birthDate(birthDateFormat.parse("28/02/2021")).email(null).build()
                )
            );
    }
}
