package com.suns.lesson5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class A {
	@Value("${a.name}")
	private String name;

	@Autowired
	private B b;

	public void showB(){
		System.out.println("A.showB()-----------");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public B getB() {
		return b;
	}

	public void setB(B b) {
		this.b = b;
	}
}
