package com.apple.mongo.service;

import com.apple.mongo.bean.User;

import java.util.List;

/**
 * Created by renxueni on 2016/6/8.
 */
public interface IUserService {

    /**
     * 获取所有记录
     * @return
     */
    public List<User> getAllUser();
}
