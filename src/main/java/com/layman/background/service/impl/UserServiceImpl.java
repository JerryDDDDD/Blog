package com.layman.background.service.impl;

import com.layman.background.dao.UserDao;
import com.layman.background.entity.User;
import com.layman.background.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public boolean checkUser(String username , String inputpassword) {
        String passsword = userDao.queryPasswordByUsername(username);
        if (passsword.equals(inputpassword)){
            return true;
        }else {
            return false;
        }
    }
}
