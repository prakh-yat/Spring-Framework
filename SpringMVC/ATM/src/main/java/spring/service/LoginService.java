package spring.service;

import spring.model.UserDetail;

public interface LoginService {

    boolean matchCred(String username, String password);

}
