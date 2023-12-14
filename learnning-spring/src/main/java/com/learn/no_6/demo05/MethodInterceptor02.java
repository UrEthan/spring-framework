package com.learn.no_6.demo05;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class MethodInterceptor02 implements MethodInterceptor {

	@Nullable
	@Override
	public Object invoke(@Nonnull MethodInvocation invocation) throws Throwable {
		System.out.println("拦截器2开始执行 ----------- method02");
		Object proceed = invocation.proceed();
		System.out.println("拦截器2执行结束********");
		return proceed;
	}
}
