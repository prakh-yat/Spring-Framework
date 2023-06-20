
package spring.service;
import spring.model.UserDetail;

public interface EmailService {

    void emailAndRegistration(String toEmail, UserDetail userDetail);
    String getGeneOtp();
}


