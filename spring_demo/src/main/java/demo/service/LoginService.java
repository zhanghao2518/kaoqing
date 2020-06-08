package demo.service;

import demo.dao.LoginDao;

import demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginDao loginDao;

    public User login(String name,String password){
        User user = loginDao.queryUserByName(name);
        if(user.getPassword().equals(password)){
            return  user;
        }
        else{
            return  null;
        }
    }
}
