package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @Autowired
    private EmailServiceImpl emailServiceImpl;
    @Autowired
    private OtpServiceImpl otpServiceImpl;


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

    @RequestMapping(path = "/verify", method = RequestMethod.POST)
    public String verify(@RequestParam("otp") String obtainedOtp) {

        if (otpServiceImpl.matchOtp(obtainedOtp, this.username)) {
            return "login";
        } else {
            return "otpF";
        }
    }

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




