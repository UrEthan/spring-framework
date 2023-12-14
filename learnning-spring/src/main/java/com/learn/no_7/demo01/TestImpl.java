package com.learn.no_7.demo01;

public class TestImpl implements TestInterface{
	@Override
	public void doSomeTest() {
		System.out.println("do some execute");
	}

	@Override
	public void doOtherTest() {
		System.out.println("do other execute");
	}

	@Override
	public void a() {
		System.out.println("a function execute");
	}

	@Override
	public void b() {
		System.out.println("b function execute");
	}
}
