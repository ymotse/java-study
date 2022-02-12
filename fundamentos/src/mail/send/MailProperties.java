package mail.send;

import java.io.File;
import java.util.List;
import java.util.Properties;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MailProperties {

    /**
     * Required!
     */
    private Properties smtpProps;

    /**
     * Required!
     */
    private List<String> emailsRecipients;
    
    /**
     * Optional :)
     */
    private List<String> emailsWithCopy;
    
    /**
     * Optional :)
     */
    private List<File> filesToAttach;
    
    /**
     * Optional :)
     */
    private String subject;
    
    /**
     * Required!
     */
    private StringBuilder messageBody;
    
    /**
     * Required!
     */
    private String messageBodyTypeAndCharset;
    
    /**
     * Required!
     */
    private String username;
    
    /**
     * Required!
     */
    private String password;
    
}
