package com.example.ejb;

import java.util.List;

import javax.ejb.Remote;

import com.example.model.Contact;

@Remote
public interface ContactRemote {

    public Contact save(Contact contact);

    public Contact update(Contact contact) throws Exception;

    public Contact findById(Long id);

    public void remove(Long id);
    
    public List<Contact> findByListId(List<Long> listId) throws Exception;
}
