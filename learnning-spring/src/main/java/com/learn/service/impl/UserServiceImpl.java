package com.learn.service.impl;

import com.learn.pojo.User;
import com.learn.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public User getUserById(int id) {
		User user = new User();
		user.setAge(18);
		user.setName("一朵花");
		user.setId(1);
		return user;
	}
}
