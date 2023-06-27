package spring.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.model.AccountDetail;
import spring.model.Transaction;


@Repository
public class TransactionDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;


    @Transactional
    public int save(Transaction transaction) {
        int i = (Integer) this.hibernateTemplate.save(transaction);
        return i;
    }
    @Transactional
    public void update(Transaction transaction){
        this.hibernateTemplate.update(transaction);
    }


    @Transactional
    public double getBalanceForAccount(String accountNo) {
        Criteria criteria = this.hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(AccountDetail.class);
        criteria.add(Restrictions.eq("accountNo", accountNo));
        AccountDetail accountDetail = (AccountDetail) criteria.uniqueResult();
        return accountDetail.getBalance();
    }

    @Transactional
    public void updateBalance(String accountNumber, double newBalance){
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(AccountDetail.class);
        criteria.add(Restrictions.eq("accountNo", accountNumber));
        AccountDetail accountDetail = (AccountDetail) criteria.uniqueResult();
        accountDetail.setBalance(newBalance);
        hibernateTemplate.update(accountDetail);
    }

}
