package com.apple.mongo.service.impl;

import com.apple.mongo.bean.User;
import com.apple.mongo.dao.IUserDao;
import com.apple.mongo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by renxueni on 2016/6/8.
 */
@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserDao userDao;

    public List<User> getAllUser(){
        return userDao.getAllUser();
    }

}
