package com.learn.no_6.demo03;

import java.lang.reflect.InvocationTargetException;

/**
 * 责任链模式
 */
public abstract class AbstractHandler {
	/**
	 * 责任链下一单元
	 */
	private AbstractHandler nextHandler;

	public void setNextHandler(AbstractHandler nextHandler) {
		this.nextHandler = nextHandler;
	}

	abstract Object invoke(TargetMethod method) throws InvocationTargetException, IllegalAccessException;

	public Object proceed(TargetMethod targetMethod) throws InvocationTargetException, IllegalAccessException {
		if (!hasNext()){
			Object ret = targetMethod.getMethod().invoke(targetMethod.getTarget(), targetMethod.getArgs());
			 return ret;
		}
		return nextHandler.invoke(targetMethod);
	}

	public boolean hasNext(){
		if (nextHandler != null){
			return true;
		}
		return false;
	}

	public static class HeadHandler extends AbstractHandler{
		@Override
		Object invoke(TargetMethod method) {
			return null;
		}
	}
}
