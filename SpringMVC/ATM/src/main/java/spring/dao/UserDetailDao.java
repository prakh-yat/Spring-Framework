package spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.model.UserDetail;

@Repository
public class UserDetailDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional
    public int save(UserDetail userDetail) {

        int i = (Integer) this.hibernateTemplate.save(userDetail);
        return i;
    }


}