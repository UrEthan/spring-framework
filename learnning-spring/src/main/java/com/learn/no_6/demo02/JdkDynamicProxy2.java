package com.learn.no_6.demo02;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkDynamicProxy2 implements InvocationHandler {
	/**
     * 被代理对象
	 */
	private Object target;

	public JdkDynamicProxy2(Object target){
		this.target = target;
	}

	/**
	 * @param proxy 代理对象 内部持有 目标对象
	 * @param method  被代理对象的方法
	 * @param args  被代理对象的参数
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//需求: 打印出方法参数个数
		System.out.println("方法参数个数为: " + (args != null ? args.length : 0));
		Object response = method.invoke(target, args);
		//需求二: 打印出 返回值
		System.out.println("方法返回值为: " + (response != null ? response : "空空空空"));
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
