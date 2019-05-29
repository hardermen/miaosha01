package com.imooc.miaosha.service;

import com.imooc.miaosha.dao.UserDao;
import com.imooc.miaosha.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User tx(){
        User u1 = new User();
        u1.setName("yangyangyang");
        u1.setPassword("yang");
        userDao.insert(u1);

        User u2 = new User();
        u2.setName("yang2");
        userDao.insert(u2);
        return u1;
    }
}
