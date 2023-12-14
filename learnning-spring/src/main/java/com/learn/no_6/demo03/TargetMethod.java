package com.learn.no_6.demo03;

import java.lang.reflect.Method;

/**
 * 封装目标方法
 */
public class TargetMethod {
	//目标对象
	private Object target;
	// 被代理接口方法
	private Method method;
	//被代理接口方法参数
	private Object[] args;

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	public Object[] getArgs() {
		return args;
	}

	public void setArgs(Object[] args) {
		this.args = args;
	}
}
