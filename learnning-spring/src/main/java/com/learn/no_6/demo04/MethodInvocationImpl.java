package com.learn.no_6.demo04;

import com.learn.no_6.demo03.TargetMethod;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class MethodInvocationImpl implements MethodInvocation{
	private TargetMethod targetMethod;
	private List<MethodInterceptor> interceptorList;
	private int index = 0;

	public MethodInvocationImpl(TargetMethod targetMethod, List<MethodInterceptor> interceptorList) {
		this.targetMethod = targetMethod;
		this.interceptorList = interceptorList;
	}

	public void setInterceptorList(List<MethodInterceptor> interceptorList){
		this.interceptorList = interceptorList;
	}
	@Override
	public Object proceed() throws InvocationTargetException, IllegalAccessException {
		//拦截器全部执行完毕 接下来执行需要被代理接口方法
		if (index == interceptorList.size()){
			return targetMethod.getMethod().invoke(targetMethod.getTarget(),targetMethod.getArgs());
		}
		//到这里 说明拦截器为执行完毕
		MethodInterceptor interceptor = interceptorList.get(index++);
		return interceptor.invoke(this);
	}
}
