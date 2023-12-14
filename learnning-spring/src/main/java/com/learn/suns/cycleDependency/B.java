package com.learn.suns.cycleDependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class B {
	@Value("${b.name}")
	private String name;
	@Autowired
	private A a;

	public void showA(){
		System.out.println("B.showA ---> A =" + a);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public A getA() {
		return a;
	}

	public void setA(A a) {
		this.a = a;
	}
}
