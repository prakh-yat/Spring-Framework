package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.stereotype.Controller;
=======

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import spring.model.Customer;
import spring.model.UserDetail;
>>>>>>> 4e34b58217db0b90ba34e7936e9d21a91fc1cf30
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spring.model.UserDetail;
import spring.service.impl.EmailServiceImpl;
import spring.service.impl.OtpServiceImpl;


import java.time.LocalDateTime;

@Controller
public class CustomerController {

    private static String username;
    private static String password;
    private static String email;

<<<<<<< HEAD
    @Autowired
    private EmailServiceImpl emailServiceImpl;
    @Autowired
    private OtpServiceImpl otpServiceImpl;
=======
    private UserDetail userDetail;
    private Customer customer;

    private static String geneOtp;
    private static String username;
    private static String password;

    @Autowired
    private EmailService emailService;
>>>>>>> 4e34b58217db0b90ba34e7936e9d21a91fc1cf30


    @RequestMapping(path = "/registration")
    public String form() {
        return "registration";
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String handle(@ModelAttribute UserDetail userDetail, Model model) {
        this.username = userDetail.getUsername();
        this.password = userDetail.getPassword();
        this.email = userDetail.getEmail();
        emailServiceImpl.emailAndRegistration(this.email, userDetail);
        return "otp";
    }

<<<<<<< HEAD
    @RequestMapping(path = "/verify", method = RequestMethod.POST)
    public String verify(@RequestParam("otp") String obtainedOtp) {
=======

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
>>>>>>> 4e34b58217db0b90ba34e7936e9d21a91fc1cf30

        if (otpServiceImpl.matchOtp(obtainedOtp, this.username)) {
            return "login";
        } else {
            return "otpF";
        }
    }

<<<<<<< HEAD
    @RequestMapping(path = "/signin", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
//        if () {
//            return "home";
//        } else {
        return "loginF";
//        }
    }

}




=======
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


>>>>>>> 4e34b58217db0b90ba34e7936e9d21a91fc1cf30
