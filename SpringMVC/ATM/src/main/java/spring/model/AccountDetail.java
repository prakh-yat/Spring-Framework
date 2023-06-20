package spring.model;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "account_details")
public class AccountDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_details_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_details_id")
    private UserDetail userDetail;

    @Column(name = "account_no")
    private String accountNo;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "primary_acc")
    private String primary;

    @Column(name = "balance")
    private double balance;


    public AccountDetail() {

    }
    public String getPrimary() { return primary; }
    public void setPrimary(String primary) {this.primary = primary;}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
