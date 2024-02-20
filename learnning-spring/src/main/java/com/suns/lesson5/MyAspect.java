package com.suns.lesson5;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

	/**
	 * 既切A又切B
	 * 代理的情况: 观察beanA 和 beanB 合适成为代理对象
	 */
	@Before("execution(* com.suns.lesson5.A.*(..)) || execution(* com.suns.lesson5.B.*(..))")
	public void before(){
		System.out.println("MyAspect before......");
	}
}
