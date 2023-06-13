package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dao.AccountDetailDao;
import spring.model.AccountDetail;
import spring.model.Customer;

@Service
public class AccountDetailService {
    @Autowired
    private AccountDetailDao accountDetailDao;
    public int registerUser(AccountDetail accountDetail){

        return this.accountDetailDao.save(accountDetail);
    }
}
