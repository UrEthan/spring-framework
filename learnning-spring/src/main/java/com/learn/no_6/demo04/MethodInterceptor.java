package com.learn.no_6.demo04;

import com.learn.no_6.demo03.TargetMethod;

import java.lang.reflect.InvocationTargetException;

public interface MethodInterceptor {

	/**
	 * 方法拦截器接口 增强逻辑 全部写在里面
	 * @param methodInvocation
	 * @return
	 */
	Object invoke(MethodInvocation methodInvocation) throws InvocationTargetException, IllegalAccessException;
}
