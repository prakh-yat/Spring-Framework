package spring.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.model.UserDetail;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class UserDetailDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional
    public int save(UserDetail userDetail) {

        int i = (Integer) this.hibernateTemplate.save(userDetail);
        return i;
    }

//    find by username
    public UserDetail getUserDetailsFromUserName(String username){
        List<UserDetail> users = (List<UserDetail>) hibernateTemplate.findByCriteria(DetachedCriteria.forClass(UserDetail.class)
                .add(Restrictions.eq("username", username)));

        return users.isEmpty() ? null : users.get(0);
    }

}