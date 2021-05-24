package com.example.dao;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
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

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        em = Mockito.mock(EntityManager.class);
    }

    @Test
    public void persist_returnsContact_whenSuccessful() throws Exception {

        Contact contactToBeSaved = ContactCreator.createContactToBeSaved();

        Mockito.doNothing().when(em).persist(contactToBeSaved);

        ContactDAO contactDAO = new ContactDAO(em);
        Contact contactSaved = contactDAO.save(contactToBeSaved);

        Assert.assertNotNull(contactSaved);
        Assert.assertEquals(contactToBeSaved.getName(), contactSaved.getName());
    }

}
