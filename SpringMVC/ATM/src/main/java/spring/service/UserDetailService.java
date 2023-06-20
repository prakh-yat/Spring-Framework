package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dao.UserDetailDao;
import spring.model.UserDetail;

@Service
public class UserDetailService {
    @Autowired
    private UserDetailDao userDetailDao;

    public int registerUser(UserDetail userDetail){

        return this.userDetailDao.save(userDetail);
    }
}
