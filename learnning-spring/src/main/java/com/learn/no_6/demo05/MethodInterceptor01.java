package com.learn.no_6.demo05;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class MethodInterceptor01 implements MethodInterceptor {

	@Nullable
	@Override
	public Object invoke(@Nonnull MethodInvocation invocation) throws Throwable {
		System.out.println("方法一拦截器开始执行 ----------- method01");
		Object proceed = invocation.proceed();
		System.out.println("拦截器一执行结束********");
		return proceed;
	}
}
