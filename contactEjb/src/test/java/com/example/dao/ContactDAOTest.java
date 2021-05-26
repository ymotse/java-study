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
    
    @Test
    public void update_returnsContact_whenSuccessful() throws Exception {
        contactDAO.save(ContactCreator.createContactToBeSaved());
        
        Contact contactToBeValidate = ContactCreator.createContactToBeValidate();
        
        Mockito.when(em.find(Mockito.eq(Contact.class), Mockito.anyLong())).thenReturn(contactToBeValidate);
        Mockito.when(em.merge(ArgumentMatchers.any(Contact.class))).thenReturn(contactToBeValidate);
        
        Contact contactUpdated = contactDAO.update(contactToBeValidate);
        
        Assert.assertNotNull(contactUpdated);
        Assert.assertEquals(contactToBeValidate, contactUpdated);
    }
    
    @Test
    public void update_returnsNull_whenContactIsEmpty() throws Exception {
        Assert.assertNull(contactDAO.update(new Contact()));
    }
    
    @Test(expected = Exception.class)
    public void update_throwsException_whenContactIsNotFound() throws Exception {
        Contact contactToBeValidate = ContactCreator.createContactToBeValidate();
        
        Mockito.when(em.find(Contact.class, Long.MAX_VALUE)).thenThrow(Exception.class);
        
        Assert.assertEquals(Exception.class, contactDAO.update(contactToBeValidate));
        Assert.assertEquals(new Exception(), contactDAO.update(contactToBeValidate));
    }
    
    @Test(expected = NullPointerException.class)
    public void update_throwsNullPointerException_whenContactIsNull() throws Exception {
        Assert.assertEquals(NullPointerException.class, contactDAO.update(null));
        Assert.assertEquals(new NullPointerException(), contactDAO.update(null));
        Assert.assertNull(contactDAO.update(null));
    }
    
    @Test
    public void findById_returnsContact_whenSuccessful() throws Exception {
        Mockito.when(em.find(Mockito.eq(Contact.class), Mockito.anyLong())).thenReturn(ContactCreator.createContactToBeValidate());
        
        Contact contactExpected = ContactCreator.createContactToBeValidate();
        
        Contact contactFinded = contactDAO.findById(Long.MAX_VALUE);
        
        Assert.assertNotNull(contactFinded);
        Assert.assertEquals(contactExpected, contactFinded);
    }
    
    @Test
    public void remove_removesContact_whenSuccessful() throws Exception {
        Mockito.when(em.find(Mockito.eq(Contact.class), Mockito.anyLong())).thenReturn(ContactCreator.createContactToBeValidate());
        
        Mockito.doNothing().when(em).remove(ContactCreator.createContactToBeValidate());
        
        contactDAO.remove(Long.MAX_VALUE);
    }
    
}
