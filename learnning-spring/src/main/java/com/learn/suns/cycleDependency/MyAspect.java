package com.learn.suns.cycleDependency;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	@Before("execution(* com.learn.suns.cycleDependency.A.*(..)) or execution(* com.learn.suns.cycleDependency.B.*(..))")
	public void before(){
		System.out.println("MyAspect.before .............");
	}
}
