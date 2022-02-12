package mail.send;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * PURPOSE FOR ONLY STUDIES
 *
 */
public class SendMailRun {

    final static Logger LOGGER = Logger.getLogger(SendMailRun.class.getName());
    static StringWriter sw = new StringWriter();
    
    final static String USERNAME = "yourEmail@outlook.com";
    final static String PASSWORD = "passwordAccount";

    public static void main(String[] args) {
        LOGGER.log(Level.INFO, "======================== Sending a Mail ========================");

        Properties smtpProps = new Properties();
        smtpProps.put("mail.transport.protocol", "smtp");
        smtpProps.put("mail.smtp.starttls.enable", "true");
        smtpProps.put("mail.smtp.ssl.protocols", "TLSv1.2");
        smtpProps.put("mail.smtp.auth", "true");
        smtpProps.put("mail.smtp.host", "outlook.office365.com");
        smtpProps.put("mail.smtp.port", "587");
        
        StringBuilder messageBody = new StringBuilder("Message Body Test");
        
        List<File> filesToAttach = new ArrayList<>();
//        filesToAttach.add(new File("/home/user/Documents/file.txt"));
        
        MailProperties properties = MailProperties.builder()
            .smtpProps(smtpProps)
            .emailsRecipients(Arrays.asList("user1@gmail.com", "user2@gmail.com"))
            .emailsWithCopy(Arrays.asList("someone@outlook.com"))
            .subject("This is an email test :)")
            .messageBodyTypeAndCharset("text/html; charset=UTF-8")
            .messageBody(messageBody)
            .filesToAttach(filesToAttach)
            .username(USERNAME)
            .password(PASSWORD)
        .build();
        
        try {
            new MailManagement().sendMail(properties);
            LOGGER.log(Level.INFO, "=================== Email successfully sent! ===================");
        } catch (Exception e) {
            e.printStackTrace(new PrintWriter(sw));
            LOGGER.log(Level.SEVERE, "[EMAIL NOT SENT]: " + sw.toString());
        }
    }
    
}
