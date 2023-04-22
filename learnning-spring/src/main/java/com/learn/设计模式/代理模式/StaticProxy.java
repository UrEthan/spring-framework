package com.learn.设计模式.代理模式;

public class StaticProxy implements StaticInterface {

	private StaticInterface target;

	public StaticProxy(StaticInterface target){
		this.target = target;
	}

	@Override
	public void say() {
		System.out.println("前置逻辑");
		target.say();
		System.out.println("后置逻辑");
	}

	public static void main(String[] args) {
		Target t = new Target();
		StaticProxy proxy = new StaticProxy(t);
		proxy.say();
	}
}
