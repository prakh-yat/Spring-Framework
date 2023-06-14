package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
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

    private UserDetail userDetail;
    private Customer customer;

    private static String geneOtp;
    private static String username;
    private static String password;

    @Autowired
    private EmailService emailService;

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
    public String handle(@ModelAttribute UserDetail userDetail, Customer customer,Model model){

        username = userDetail.getUsername();
//        userDetail.setPassword(this.bCryptPasswordEncoder.encode(userDetail.getPassword()));
        password = userDetail.getPassword();

        String email = userDetail.getEmail();
        geneOtp = generateOTP();
        String subject = "OTP confirmation";
        String body = "Your otp is "+geneOtp;
        this.customer=customer;
        this.userDetail=userDetail;

        emailService.sendEmail(email,subject,body);
        return "otp";

    }

    @RequestMapping(path="/verify",method= RequestMethod.POST)
    public String verify(@RequestParam ("otp") String obtainedOtp){
        if(obtainedOtp.equals(this.geneOtp)){
            this.customerService.registerUser(this.customer);
            System.out.println(this.customer);
            this.userDetailService.registerUser(this.userDetail);
            return "login";
        }
        else {
            return "otpF";
        }
    }

    @RequestMapping(path="/signin",method= RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
        if (username.equals(CustomerController.username) && password.equals(CustomerController.password)) {
            return "home";
        } else {
            return "loginF";
        }
    }
}


