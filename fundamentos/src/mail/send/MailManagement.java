package mail.send;

import java.io.File;
import java.util.List;
import java.util.regex.Pattern;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailManagement {

    private final static String EMAIL_REGEX = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    
    public void sendMail(MailProperties props) throws Exception {
        if(props == null) 
            throw new Exception("Properties must be provided!");
        
        MimeMessage message = new MimeMessage(Session.getInstance(props.getSmtpProps(), null));

        message.setFrom(new InternetAddress(props.getUsername(), "The Sender :D"));
        message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(validateEmails(props.getEmailsRecipients(), true)));
        message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(validateEmails(props.getEmailsWithCopy(), false)));
        message.setSubject(props.getSubject());

        Multipart multipart = prepareMultipartAttachments(props.getFilesToAttach());
        multipart.addBodyPart(prepareBodyMessage(props.getMessageBody(), props.getMessageBodyTypeAndCharset()));

        message.setContent(multipart);

        Transport.send(message, props.getUsername(), props.getPassword());
    }
    
    public String validateEmails(List<String> emails, boolean requiredEmail) throws Exception {
        if(requiredEmail)
            if(emails == null || emails.size() == 0)
                throw new Exception("Type at least one valid email");
        
        String emailsWithComma = "";

        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        
        for (String email : emails) {
            if(pattern.matcher(email).matches()) 
                emailsWithComma += email + ", ";
        }

        return emailsWithComma;
    }

    public MimeBodyPart prepareBodyMessage(StringBuilder messageBody, String charset) throws Exception {
        if(messageBody.toString().trim().equals("") || messageBody == null)
            throw new Exception("Message body cannot be empty.");
        
        if(charset.trim().equals("") || charset == null)
            throw new Exception("Required a valid charset.");
        
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(messageBody.toString(), charset);
        
        return messageBodyPart;
    }

    public Multipart prepareMultipartAttachments(List<File> listAttachments) throws Exception {
        if(listAttachments == null || listAttachments.size() == 0)
            return new MimeMultipart();
        
        Multipart multipart = new MimeMultipart();
        
        for (File file : listAttachments) {
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.attachFile(file.getAbsoluteFile());
            multipart.addBodyPart(mimeBodyPart);
        }
        
        return multipart;
    }

}
