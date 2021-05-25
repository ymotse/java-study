package com.example.dao;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.example.ContactCreator;
import com.example.model.Contact;

import junit.framework.TestCase;

@RunWith(JUnit4.class)
public class ContactDAOTest extends TestCase {

    @Mock
    private EntityManager em;
    
    ContactDAO contactDAO;
    
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        em = Mockito.mock(EntityManager.class);

        contactDAO = new ContactDAO(em);
    }

    @Test
    public void persist_returnsContact_whenSuccessful() throws Exception {
        Contact contactToBeSaved = ContactCreator.createContactToBeSaved();

        Mockito.doNothing().when(em).persist(contactToBeSaved);

        Contact contactSaved = contactDAO.save(contactToBeSaved);

        Assert.assertNotNull(contactSaved);
        Assert.assertEquals(contactToBeSaved.getName(), contactSaved.getName());
    }
    
    @Test
    public void persist_returnsNull_whenIdIsNull() throws Exception {
        Assert.assertNull(contactDAO.save(ContactCreator.createContactToBeValidate()));
    }
    
    @Test(expected = NullPointerException.class)
    public void persist_throwsNullPointerException_whenContactIsNull() {
        Mockito.doThrow(new NullPointerException()).when(em).persist(ArgumentMatchers.any(Contact.class));
        
        Assert.assertEquals(new NullPointerException(), contactDAO.save(new Contact()));
        Assert.assertNull(contactDAO.save(null));
    }
    
}
