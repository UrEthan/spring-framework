package com.learn.no_6.demo01;

public class Main {
	public static void main(String[] args) {
		//1.创建目标对象
		Cat cat = new Cat();
		cat.eat();
		System.out.println("------------------分隔符--------------------");
		//2.创建JdkDynamicProxy对象
		JdkDynamicProxy dynamicProxy = new JdkDynamicProxy(cat);
		//3.获取代理之后的对象
		Animal proxy = (Animal)dynamicProxy.getProxy();
		proxy.eat();

	}
}
