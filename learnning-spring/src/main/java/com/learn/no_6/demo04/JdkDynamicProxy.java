package com.learn.no_6.demo04;

import com.learn.no_6.demo03.AbstractHandler;
import com.learn.no_6.demo03.TargetMethod;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class JdkDynamicProxy implements InvocationHandler {
	/**
     * 被代理对象
	 */
	private Object target;

    /**
	 * 方法拦截器列表
	 */
	private List<MethodInterceptor> interceptorList = new ArrayList<>();

	public JdkDynamicProxy(Object target){
		this.target = target;
	}

	public void addInterceptor(MethodInterceptor interceptor) {
		this.interceptorList.add(interceptor);
	}

	/**
	 *  需求：打印所有动物吃饭时间
	 * @param proxy 代理对象 内部持有 目标对象
	 * @param method  被代理对象的方法
	 * @param args  被代理对象的参数
	 * 回调方法 代理对象回调
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		TargetMethod targetMethod = new TargetMethod();
		targetMethod.setTarget(target);
		targetMethod.setMethod(method);
		targetMethod.setArgs(args);
		MethodInvocationImpl invocation = new MethodInvocationImpl(targetMethod,interceptorList);
		Object ret = invocation.proceed();
		return ret;
	}

	public Object getProxy(){ //获取代理对象
		//参数一:类加载器 代理对象需要持有目标对象 存疑问🤔️ 第三个参数this包含了target
		//参数二:代理对象要和目标对象实现相同的接口
		//参数三:this表示要传入当前对象JdkDynamicProxy 代理类虽然全部实现了接口方法 但是要依靠 InvocationHandler 去处理
		//TODO: 查看newProxyInstance源码
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
	}
}
