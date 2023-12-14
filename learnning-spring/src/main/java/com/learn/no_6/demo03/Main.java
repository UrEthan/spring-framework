package com.learn.no_6.demo03;

import com.learn.no_6.demo01.Animal;
import com.learn.no_6.demo01.Cat;

import java.lang.reflect.InvocationTargetException;

public class Main {
	public static void main(String[] args) {
		//1.第一步 创建目标对象
		Cat cat = new Cat();
		//2.创建一个责任链
		AbstractHandler.HeadHandler headHandler = new AbstractHandler.HeadHandler();
		OneHandler oneHandler = new OneHandler();
		oneHandler.setNextHandler(new TwoHandler());
		headHandler.setNextHandler(oneHandler);
		//3.先创建一个 jdkDynamicProxy对象
		JdkDynamicProxy jdkDynamicProxy = new JdkDynamicProxy(cat, headHandler);
		//4.获取代理对象
		Animal proxy = (Animal)jdkDynamicProxy.getProxy();
		proxy.eat();
	}

	public static class OneHandler extends AbstractHandler{
		@Override
		Object invoke(TargetMethod method) throws InvocationTargetException, IllegalAccessException {
			System.out.println("one Handler begin********");
			Object proceed = proceed(method);
			System.out.println("one Handler end---------->");
			return proceed;
		}
	}

	public static class TwoHandler extends AbstractHandler{
		@Override
		Object invoke(TargetMethod method) throws InvocationTargetException, IllegalAccessException {
			System.out.println("2 Handler begin********");
			Object proceed = proceed(method);
			System.out.println("2 Handler end---------->");
			return proceed;
		}
	}
}
