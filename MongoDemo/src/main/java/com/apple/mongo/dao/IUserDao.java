package com.apple.mongo.dao;

import com.apple.mongo.bean.User;

import java.util.List;

/**
 * Created by renxueni on 2016/6/7.
 */
public interface IUserDao {

    /**
     * 保存记录
     * @param user
     */
    public void saveUser(User user);

    /**
     * 批量保存记录
     * @param users
     */
    public void saveUserBatch(List<User> users);

    /**
     * 获取所有记录
     * @return
     */
    public List<User> getAllUser();

    /**
     * 根据 id 获取记录
     * @param id
     * @return
     */
    public User findById(String id);

    /**
     * 根据条件获取记录列表
     * @param user
     * @return
     */
    public List<User> getUserList(User user);

    /**
     * 根据 Id 更新
     * @param id
     */
    public void updateById(String id,String key,String value);

    /**
     * 根据 id 删除
     * @param id
     */
    public void deleteById(String id);
}
