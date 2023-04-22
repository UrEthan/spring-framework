package com.learn.pojo;

import com.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;


public class Out {
	@Autowired
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
