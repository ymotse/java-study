package com.example.dao;

import javax.persistence.EntityManager;

import com.example.model.Contact;

public class ContactDAO {
    
    private EntityManager em;
    
    public ContactDAO(EntityManager em) {
        this.em = em;
    }
    
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
    
}
