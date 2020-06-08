package demo.controller;


import demo.entity.User;
import demo.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public User getUser(@RequestParam(value = "name") String name, @RequestParam(value = "password") String password) {
        if(StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("用户名不能为空");
        }
        if(StringUtils.isEmpty(password)) {
            throw new IllegalArgumentException("密码不能为空");
        }
        User login = loginService.login(name, password);
        if(login==null){
            throw new IllegalArgumentException("未查询到该用户的相关信息");
        }
        return loginService.login(name,password);
    }
}
