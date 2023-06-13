package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dao.CustomerDao;
import spring.model.Customer;

@Service
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;

    public int registerUser(Customer customer){

        return this.customerDao.save(customer);
    }
}
