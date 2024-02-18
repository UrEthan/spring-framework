package com.suns.lesson3;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class UserServiceImpl implements UserService , BeanFactoryAware {
	/**
	 * UserDao必须线程安全 1.每个人一份，那么就不能用单例 创建bean时指定 userDao为 多例 OR 2.给其上锁
	 */
	private UserDao userDao;

	public void setUserDao(UserDao userDao){
		this.userDao = userDao;
	}

	public UserDao getUserDao(){
		return userDao;
	}

	private BeanFactory beanFactory;

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}

	@Override
	public void register() {
		//解决注入UserDao失效的问题
		UserDao userDao1 = (UserDao)beanFactory.getBean("userDao");
		System.out.println("factory中的dao是--->"+ userDao1);
		System.out.println("service中的dao是--->"+ userDao);
		userDao.save();
	}
}
