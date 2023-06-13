package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.view.RedirectView;
import spring.model.Customer;
import spring.model.UserDetail;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.service.CustomerService;
import spring.service.EmailService;
import spring.service.UserDetailService;

import java.util.Random;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserDetailService userDetailService;

    @RequestMapping(path="/registration")
    public String form(){
        return "registration";
    }

    private String generateOTP() {
        Random random = new Random();
        int ot = 100000 + random.nextInt(900000);
        return String.valueOf(ot);
    }

    @RequestMapping(path="/register",method= RequestMethod.POST)
    public RedirectView handle(@ModelAttribute Customer customer, UserDetail userDetail, Model model){
        System.out.println(customer);
        this.customerService.registerUser(customer);
        this.userDetailService.registerUser(userDetail);

        String email = userDetail.getEmail();
        String otp = generateOTP();
        String subject = "OTP confirmation";
        String body = "Your otp is"+otp;

        emailService.sendEmail(email,subject,body);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/otp.jsp");
        return redirectView;

    }
}
