package com.apple.mongo.dao.impl;

import com.apple.mongo.bean.User;
import com.apple.mongo.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by renxueni on 2016/6/7.
 */
@Repository
public class UserDaoImpl implements IUserDao{

    @Autowired
    private MongoTemplate mongoTemplate;

    public void saveUser(User user){
         mongoTemplate.save(user);
    }

    public void saveUserBatch(List<User> users){
        mongoTemplate.insert(users,User.class);
    }

    public List<User> getAllUser(){
        return mongoTemplate.findAll(User.class);
    }

    public User findById(String id){
        return mongoTemplate.findById(id,User.class);
    }

    public List<User> getUserList(User user){
        Query query = getQuery(user);
        return mongoTemplate.find(query,User.class);
    }

    private Query getQuery(User user){

        Query query = new Query();
        if(null != user){
            if (null != user.getUserId()){
                Criteria criteria = Criteria.where("userId").is(user.getUserId());
                query.addCriteria(criteria);
            }

            if (null != user.getUserName()){
                Criteria criteria = Criteria.where("userName").is(user.getUserName());
                query.addCriteria(criteria);
            }

            if (null != user.getAge()){
                Criteria criteria = Criteria.where("age").is(user.getAge());
                query.addCriteria(criteria);
            }

            if (null != user.getCreateTime()){
                Criteria criteria = Criteria.where("createTime").is(user.getCreateTime());
                query.addCriteria(criteria);
            }
        }

        query.with(new Sort(new Sort.Order(Sort.Direction.ASC,"createTime")));

        return query;
    }

    //updateFirst 更新符合条件的第一条记录，updateMulti 更新符合条件的所有记录
    public void updateById(String id,String key,String value){
        mongoTemplate.updateFirst(Query.query(Criteria.where("_id").is(id)),
                                  Update.update(key, value),
                                  User.class);
    }

    public void deleteById(String id){
        mongoTemplate.remove(Query.query(Criteria.where("_id").is(id)),User.class);
    }
}
