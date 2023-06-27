package spring.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.model.AccountDetail;
import spring.model.UserDetail;

import java.util.Collections;
import java.util.List;


@Repository
public class AccountDetailDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional
    public int save(AccountDetail accountDetail) {
        int i = (Integer) this.hibernateTemplate.save(accountDetail);
        return i;
    }

    @Transactional
    public List<String> getAllAccountNumbers() {
        Criteria criteria = hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(AccountDetail.class);
        criteria.setProjection(Projections.property("accountNo"));
        List<String> accountNumbers = criteria.list();
        return accountNumbers;
    }

    public List<AccountDetail> getAll(int id){
        List<AccountDetail> accountDetail = this.hibernateTemplate.loadAll(AccountDetail.class);
        return accountDetail;
    }


}