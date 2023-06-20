package spring.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "user_details")
public class UserDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_details_id")
    private int id;

    @Column(name = "name")
    private String customerName;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email", unique = true)
    private String email;

    @OneToMany(mappedBy = "userDetail", cascade = CascadeType.ALL)
    private List<AccountDetail> accountDetails;

    @Column(name = "otp")
    private String otp;

    @Column(name = "otp_send_time")
    private LocalDateTime otpSendTime;

    public UserDetail(int id, String customerName, String username, String password, String email, List<AccountDetail> accountDetails, String otp, LocalDateTime otpSendTime) {
        this.id = id;
        this.customerName = customerName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.accountDetails = accountDetails;
        this.otp = otp;
        this.otpSendTime = otpSendTime;
    }

    public UserDetail() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<AccountDetail> getAccountDetails() {
        return accountDetails;
    }

    public void setAccountDetails(List<AccountDetail> accountDetails) {
        this.accountDetails = accountDetails;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public LocalDateTime getOtpSendTime() {
        return otpSendTime;
    }

    public void setOtpSendTime(LocalDateTime otpSendTime) {
        this.otpSendTime = otpSendTime;
    }
}
