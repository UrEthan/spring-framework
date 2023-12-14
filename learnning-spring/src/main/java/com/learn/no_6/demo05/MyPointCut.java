package com.learn.no_6.demo05;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;

import java.lang.reflect.Method;

public class MyPointCut implements Pointcut {
	@Override
	public ClassFilter getClassFilter() {
		return new ClassFilter() {
			@Override
			public boolean matches(Class<?> clazz) {
				return true;
			}
		};
	}

	@Override
	public MethodMatcher getMethodMatcher() {
		//只增强go 不增强eat
		return new MethodMatcher() {
			@Override
			public boolean matches(Method method, Class<?> targetClass) {
				if (method.getName().equals("eat")){
					return true;
				}
				return false;
			}

			@Override
			public boolean isRuntime() {
				return false;
			}

			@Override
			public boolean matches(Method method, Class<?> targetClass, Object... args) {
				return false;
			}
		};
	}
}
