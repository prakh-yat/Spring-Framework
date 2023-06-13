package spring.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.model.Customer;

@Repository
public class CustomerDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional
    public int save(Customer customer) {

       int i = (Integer) this.hibernateTemplate.save(customer);
        return i;
    }


}