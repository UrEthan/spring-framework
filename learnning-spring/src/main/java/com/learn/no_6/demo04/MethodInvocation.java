package com.learn.no_6.demo04;

import java.lang.reflect.InvocationTargetException;

public interface MethodInvocation {
	Object proceed() throws InvocationTargetException, IllegalAccessException;
}
