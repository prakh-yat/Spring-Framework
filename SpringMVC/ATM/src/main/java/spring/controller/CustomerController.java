package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spring.dao.AccountDetailDao;
import spring.dao.UserDetailDao;
import spring.model.AccountDetail;
import spring.model.UserDetail;
import spring.service.impl.EmailServiceImpl;
import spring.service.impl.LoginServiceImpl;
import spring.service.impl.OtpServiceImpl;

import java.util.List;


@Controller
public class CustomerController {

    private static String username;
    private static String password;
    private static String encodedPassword;
    private static String email;
    private final UserDetailDao userDetailDao;
    private final AccountDetailDao accountDetailDao;


    @Autowired
    private EmailServiceImpl emailServiceImpl;
    @Autowired
    private OtpServiceImpl otpServiceImpl;
    @Autowired
    private LoginServiceImpl loginServiceImpl;



    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public CustomerController(UserDetailDao userDetailDao, AccountDetailDao accountDetailDao) {
        this.userDetailDao = userDetailDao;
        this.accountDetailDao = accountDetailDao;
    }


    @RequestMapping(path = "/registration")
    public String form() {
        return "registration";
    }
    @RequestMapping(path = "/profile")
    public String profile() {
        return "profile";
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String handle(@ModelAttribute UserDetail userDetail) {
        this.username = userDetail.getUsername();
        this.password = userDetail.getPassword();
        this.encodedPassword = bCryptPasswordEncoder.encode(this.password);
        userDetail.setPassword(this.encodedPassword);
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
                        @RequestParam("password") String password, Model model) {

        if (loginServiceImpl.matchCred(username,password)) {
            UserDetail userDetail = userDetailDao.getUserDetailsFromUserName(username);
            model.addAttribute("ud" ,userDetail);
            List<AccountDetail> accountDetail = accountDetailDao.getAll(userDetail.getId());
            model.addAttribute("ad",accountDetail);
            model.addAttribute("id",userDetail.getId());
            return "home";
        } else {
        return "loginF";
        }
    }

    @RequestMapping(path = "/login")
    public String login(){
            return "login";
    }
}






