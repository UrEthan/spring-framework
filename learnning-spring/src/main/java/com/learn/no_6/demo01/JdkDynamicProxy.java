package com.learn.no_6.demo01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkDynamicProxy implements InvocationHandler {
	/**
	 * 被代理对象
	 */
	private Object target;

	public JdkDynamicProxy(Object target){
		this.target = target;
	}

	/**
	 *  需求：打印所有动物吃饭时间
	 * @param proxy 代理对象 内部持有 目标对象
	 * @param method  被代理对象的方法
	 * @param args  被代理对象的参数
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("开始时间:" + System.currentTimeMillis());
		Object response = method.invoke(target, args);
		System.out.println("结束时间:" + System.currentTimeMillis());
		return response;
	}

	public Object getProxy(){ //获取代理对象
		//参数一:类加载器 代理对象需要持有目标对象 存疑问🤔️ 第三个参数this包含了target
		//参数二:代理对象要和目标对象实现相同的接口
		//参数三:this表示要传入当前对象JdkDynamicProxy 代理类虽然全部实现了接口方法 但是要依靠 InvocationHandler 去处理
		//TODO: 查看newProxyInstance源码
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
	}
}
