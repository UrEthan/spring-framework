package com.suns.lesson3;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * BeanNameAware Spring容器级的注入
 */
public class User implements BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean{
	private String id;

	private String name;

	private String userFactoryName;

	private BeanFactory myFactory;

	public void myInit(){
		System.out.println("初始化方法myInit,需通过bean配置init-method告知Spring调用");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		//与上myInit等价
		System.out.println("初始化方法afterPropertiesSet,需实现InitializingBean接口告知Spring调用");
	}

	public void myDestroy(){
		System.out.println("对象销毁方法 myDestroy,需通过bean配置destroy-method告知Spring调用");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("对象销毁方法 destroy,需实现DisposableBean接口告知Spring调用");
	}

	@Override
	public void setBeanName(String name) {
		//spring会回调该方法
		this.userFactoryName = name;

	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.myFactory = beanFactory;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void showFactoryName(){
		System.out.println(" bean id is --->>>" + userFactoryName);
	}

	public void showMyFactory(){
		System.out.println(" bean factory is --->>>" + myFactory);
	}
}
