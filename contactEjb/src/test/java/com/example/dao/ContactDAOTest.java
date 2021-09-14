package com.example.dao;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;

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
        initMocks(this);

        em = mock(EntityManager.class);

        contactDAO = new ContactDAO(em);
    }

    @Test
    public void persist_returnsContact_whenSuccessful() throws Exception {
        Contact contactToBeSaved = ContactCreator.createContactToBeSaved();

        doNothing().when(em).persist(contactToBeSaved);

        Contact contactSaved = contactDAO.save(contactToBeSaved);

        assertNotNull(contactSaved);
        assertEquals(contactToBeSaved.getName(), contactSaved.getName());
    }
    
    @Test
    public void persist_returnsNull_whenIdIsNull() throws Exception {
        assertNull(contactDAO.save(ContactCreator.createContactToBeValidate()));
    }
    
    @Test(expected = NullPointerException.class)
    public void persist_throwsNullPointerException_whenContactIsNull() {
        doThrow(new NullPointerException()).when(em).persist(any(Contact.class));
        
        assertEquals(new NullPointerException(), contactDAO.save(new Contact()));
        assertNull(contactDAO.save(null));
    }
    
    @Test
    public void update_returnsContact_whenSuccessful() throws Exception {
        contactDAO.save(ContactCreator.createContactToBeSaved());
        
        Contact contactToBeValidate = ContactCreator.createContactToBeValidate();
        
        when(em.find(eq(Contact.class), anyLong())).thenReturn(contactToBeValidate);
        when(em.merge(any(Contact.class))).thenReturn(contactToBeValidate);
        
        Contact contactUpdated = contactDAO.update(contactToBeValidate);
        
        assertNotNull(contactUpdated);
        assertEquals(contactToBeValidate, contactUpdated);
    }
    
    @Test
    public void update_returnsNull_whenContactIsEmpty() throws Exception {
        assertNull(contactDAO.update(new Contact()));
    }
    
    @Test(expected = Exception.class)
    public void update_throwsException_whenContactIsNotFound() throws Exception {
        Contact contactToBeValidate = ContactCreator.createContactToBeValidate();
        
        when(em.find(Contact.class, Long.MAX_VALUE)).thenThrow(Exception.class);
        
        assertEquals(Exception.class, contactDAO.update(contactToBeValidate));
        assertEquals(new Exception(), contactDAO.update(contactToBeValidate));
    }
    
    @Test(expected = NullPointerException.class)
    public void update_throwsNullPointerException_whenContactIsNull() throws Exception {
        assertEquals(NullPointerException.class, contactDAO.update(null));
        assertEquals(new NullPointerException(), contactDAO.update(null));
        assertNull(contactDAO.update(null));
    }
    
    @Test
    public void findById_returnsContact_whenSuccessful() throws Exception {
        when(em.find(eq(Contact.class), anyLong())).thenReturn(ContactCreator.createContactToBeValidate());
        
        Contact contactExpected = ContactCreator.createContactToBeValidate();
        
        Contact contactFinded = contactDAO.findById(Long.MAX_VALUE);
        
        assertNotNull(contactFinded);
        assertEquals(contactExpected, contactFinded);
    }
    
    @Test
    public void remove_removesContact_whenSuccessful() throws Exception {
        when(em.find(eq(Contact.class), anyLong())).thenReturn(ContactCreator.createContactToBeValidate());
        
        doNothing().when(em).remove(ContactCreator.createContactToBeValidate());
        
        contactDAO.remove(Long.MAX_VALUE);
    }
    
    @Test
    public void findByListId_returnsContactList_whenSuccessful() throws Exception {
        Query queryMock = mock(Query.class);

        String queryString = "SELECT id, name, TO_CHAR(birth_date, 'dd/mm/yyyy'), email FROM contact WHERE id IN (:ids)";

        when(em.createNativeQuery(queryString)).thenReturn(queryMock);
        when(queryMock.getResultList()).thenReturn(ContactCreator.createTwoObjectContactsInList());

        List<Contact> contacts = contactDAO.findByListId(Arrays.asList(anyLong()));

        assertNotNull(contacts);
        assertEquals(ContactCreator.createTwoContactsInListToBeValidate(), contacts);
        assertEquals(ContactCreator.createTwoContactsInListToBeValidate().get(0), contacts.get(0));
        assertNull(contacts.get(1).getEmail());
    }
    
}
