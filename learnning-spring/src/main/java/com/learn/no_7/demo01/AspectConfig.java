package com.learn.no_7.demo01;

import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * gradle 导入AOP依赖失败
 */
//@Aspect
public class AspectConfig {
	/**
	 * 如何定义一个切点
	 * 例如: com.learn包下所有以test结尾的方法
	 */
	//@PonitCut("execution(* com.learn..*.*test(..))")
	public void test(){

	}

	/**
	 * 定义一个前置通知
	 */
	//@Before(value = "test()")
	public void beforeAdvice(){
		System.out.println("before advice ----------");
	}

	/**
	 * 定义一个后置通知
	 */
	//@After(value = "test()")
	public void afterAdvice(){
		System.out.println("after advice ----------");
	}

	/**
	 * 定义一个环绕通知
	 */
	//@Around(value = "execution(* com.learn..*.*test(..))")
	public void aroundAdvice(MethodInvocationProceedingJoinPoint joinPoint){
		System.out.println("around advice ----------");
		//joinPoint.proceed();
	}
}
