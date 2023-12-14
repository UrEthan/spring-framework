package com.learn.no_6.demo01;

public class Cat implements Animal{
	public void eat(){
		System.out.println("喵喵开始吃东西了");
	}

	@Override
	public void go() {
		System.out.println("喵喵开始跑了");
	}
}
