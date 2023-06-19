package spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.model.AccountDetail;
import spring.model.UserDetail;


@Repository
public class AccountDetailDao {


    @Autowired
    private HibernateTemplate hibernateTemplate;



    @Transactional
    public int save(AccountDetail accountDetail) {

        int i = (Integer) this.hibernateTemplate.save(accountDetail);
        return i;
    }



}