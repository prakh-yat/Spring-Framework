package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dao.AccountDetailDao;
import spring.model.AccountDetail;
import spring.model.UserDetail;

import java.util.Random;

@Service
public class AccountDetailService {

    private final String[] accountTypes = {"Savings", "Transaction", "Investment"};

    public String accountType(){
        Random random = new Random();
        int index = random.nextInt(accountTypes.length);
        String accountType = accountTypes[index];
        return accountType;
    }

    public String accountNumber(){
        Random random = new Random();
        long randomNumber = random.nextLong();
        String accNO = String.valueOf(Math.abs(randomNumber));
        while (accNO.length() <= 16) {
            accNO = "0" + accNO;
        }
        return accNO;
    }

    @Autowired
    private AccountDetailDao accountDetailDao;



    public int generateAccountDetails(){
        AccountDetail accountDetail = new AccountDetail();
        accountDetail.setAccountNo(accountNumber());
        accountDetail.setAccountType(accountType());
        accountDetail.setPrimary("yes");
        accountDetail.setBalance(5000.00);
        return this.accountDetailDao.save(accountDetail);
    }

}
