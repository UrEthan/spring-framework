package com.learn.设计模式.代理模式;

public class Target implements StaticInterface{

	private String name;

	public void say(){
		System.out.println("我是目标对象--------");
	}
}
