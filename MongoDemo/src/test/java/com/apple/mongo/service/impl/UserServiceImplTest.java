package com.apple.mongo.service.impl;

import com.apple.mongo.bean.User;
import com.apple.mongo.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext-mvc.xml",
								   "classpath:spring/applicationContext-dao.xml",
								   "classpath:spring/applicationContext-service.xml"})
public class UserServiceImplTest {

	@Autowired
	private IUserService userService;

	@Test
	public void test() {
		List<User> users = userService.getAllUser();
		for (User user:users ) {
			System.out.println(user.toString());
		}
	}

}
