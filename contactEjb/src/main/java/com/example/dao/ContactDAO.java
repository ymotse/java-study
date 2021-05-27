package com.example.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.example.model.Contact;

public class ContactDAO {
    
    private EntityManager em;
    
    public ContactDAO(EntityManager em) {
        this.em = em;
    }
    
    static DateFormat birthDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    public Contact save(Contact contact) {
        if(contact.getId() == null) {
            em.persist(contact);
            return contact;
        }
        
        return null;
    }
    
    public Contact update(Contact contact) throws Exception {
        if(contact.getId() != null) {
            if(em.find(Contact.class, contact.getId()) == null) {
                throw new Exception();
            }
            
            return em.merge(contact);
        }
        return null;
    }
    
    public Contact findById(Long id) {
        return em.find(Contact.class, id);
    }
    
    public void remove(Long id) {
        Contact contact = findById(id);
        em.remove(contact);
    }
    
    public List<Contact> findByListId(List<Long> listIds) throws Exception {

        Query q = em.createNativeQuery("SELECT id, name, TO_CHAR(birth_date, 'dd/mm/yyyy'), email FROM contact WHERE id IN (:ids)");

        q.setParameter("ids", listIds);

        @SuppressWarnings("unchecked")
        List<Object[]> results = (List<Object[]>) q.getResultList();

        List<Contact> contacts = new ArrayList<>();
        for (Object[] contactObject : results) {
            Long id = Long.parseLong(contactObject[0].toString());
            String name = contactObject[1].toString();
            Date birthDate = birthDateFormat.parse(contactObject[2].toString());
            String email = contactObject[3] != null ? contactObject[3].toString() : null;

            contacts.add(new Contact(id, name, birthDate, email));
        }

        return contacts;
    }

}
