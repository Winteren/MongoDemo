package com.apple.mongo.dao.impl;

import com.apple.mongo.bean.User;
import com.apple.mongo.dao.IUserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext-mvc.xml",
								   "classpath:spring/applicationContext-dao.xml",
								   "classpath:spring/applicationContext-service.xml"})
public class UserDaoImplTest {

	@Autowired
	private IUserDao userDao;

	@Test
	public void testSaveUser(){
		User user = new User();
		user.setUserId("1122");
		user.setUserName("apple");
		user.setRealName("Apple");
		userDao.saveUser(user);
	}

	@Test
	public void testSaveUserBatch(){
		List<User> users = new ArrayList<User>();
		for (int i=111;i<122;i++){
			User user = new User();
			user.setUserId(String.valueOf(i));
			user.setUserName("apple"+i);
			user.setRealName("Apple"+i);
			user.setSex(i%2==0?0:1);
			user.setAge(i);
			user.setMobile("132");
			user.setPhone("789321");
			user.setAddress("天使街123号");
			user.setCreateTime(new Date());
			user.setUpdateTime(new Date());
			user.setRemark("test data");
			users.add(user);
		}

		userDao.saveUserBatch(users);
	}

	@Test
	public void testGetAllUser() {
		List<User> users = userDao.getAllUser();
		for (User user:users ) {
			System.out.println(user.toString());

		}
	}

	@Test
	public void testFindById(){
		User user = userDao.findById("5757cd1e227dfd25d052598e");
		System.out.println(user);
	}

	@Test
	public void testGetUserList(){
		User userParam = new User();
		//userParam.setUserId("111");
		//userParam.setUserName("apple112");
		//userParam.setAge(113);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			userParam.setCreateTime(sdf.parse("2016/6/8 7:45:34"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		List<User> users = userDao.getUserList(userParam);
		for (User user:users ) {
			System.out.println(user.toString());

		}
	}

	@Test
	public void testUpdateById(){
		userDao.updateById("5757cd1e227dfd25d0525990","mobile","110110112");
		User user = userDao.findById("5757cd1e227dfd25d0525990");
		System.out.println(user.toString());
	}

	@Test
	public void testDeleteById(){
		userDao.deleteById("5757ccc7227dfd2660eeb9b0");
	}

}
