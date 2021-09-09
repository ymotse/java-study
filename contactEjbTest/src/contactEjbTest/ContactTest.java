package contactEjbTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.example.ejb.ContactRemote;
import com.example.model.Contact;

public class ContactTest {

    public static void main(String[] args) throws NamingException, Exception {
        
        InitialContext ctx = new InitialContext();
        
        ContactRemote ejb = (ContactRemote) ctx.lookup("ContactBean/remote");
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        
        Contact contact = new Contact();
        contact.setName("João da Silva");
        contact.setEmail("email@mail.com");
        contact.setBirthDate(df.parse("05/07/1991"));
        
        Contact contactSaved = ejb.save(contact);
        
        System.out.println(contactSaved.toString());
        
    }

}
