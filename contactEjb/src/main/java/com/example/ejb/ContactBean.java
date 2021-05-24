package com.example.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.dao.ContactDAO;
import com.example.model.Contact;

@Stateless
public class ContactBean implements ContactRemote {

    @PersistenceContext(unitName = "contactEjb")
    private EntityManager em;

    @Override
    public Contact save(Contact contact) {
        ContactDAO contactDAO = new ContactDAO(em);
        return contactDAO.save(contact);
    }

    @Override
    public Contact update(Contact contact) throws Exception {
        ContactDAO contactDAO = new ContactDAO(em);
        return contactDAO.update(contact);
    }

    @Override
    public Contact findById(Long id) {
        ContactDAO contactDAO = new ContactDAO(em);
        return contactDAO.findById(id);
    }

    @Override
    public void remove(Long id) {
        ContactDAO contactDAO = new ContactDAO(em);
        contactDAO.remove(id);
    }

}
