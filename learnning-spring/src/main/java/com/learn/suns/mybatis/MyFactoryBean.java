package com.learn.suns.mybatis;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * myBatis整合Spring  使用FactoryBean创建Dao代理类并完成bd注册
 * 最后service 可以完成@Autowired依赖注入 使用Dao
 * 思考这里的MyFactoryBean为何没加@Component注解？
 */
public class MyFactoryBean implements FactoryBean<UserDao> {
	@Override
	public UserDao getObject() throws Exception {
		UserDao userDao = (UserDao)  Proxy.newProxyInstance(MyFactoryBean.class.getClassLoader(),new Class[]{UserDao.class},(Object proxy, Method method, Object[] args) -> {
			System.out.println("这是Dao接口的实现类");
			return null;
		});
		return userDao;
	}

	@Override
	public Class<?> getObjectType() {
		return UserDao.class;
	}
}
