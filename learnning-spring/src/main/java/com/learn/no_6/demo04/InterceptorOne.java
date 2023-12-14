package com.learn.no_6.demo04;

import java.lang.reflect.InvocationTargetException;

public class InterceptorOne implements MethodInterceptor{
	@Override
	public Object invoke(MethodInvocation methodInvocation) throws InvocationTargetException, IllegalAccessException {
		System.out.println("拦截器一 增强 begin--------->");
		Object ret = methodInvocation.proceed();
		System.out.println("拦截器一 增强 end ************");
		return ret;
	}
}
