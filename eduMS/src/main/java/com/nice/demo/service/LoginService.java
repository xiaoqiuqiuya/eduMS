package com.nice.demo.service;

import com.nice.demo.mapper.LoginMapper;
import com.nice.demo.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    LoginMapper loginMapper;

    public Teacher login(String account, String password) {
        Teacher teacher = loginMapper.login(account,password);
        return  teacher;
    }
}
