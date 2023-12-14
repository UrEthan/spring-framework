package com.learn.suns.invokeBeanFactoryPostProcessors;

import org.springframework.stereotype.Component;

/**
 * 外部类里面的内部类也使用了Spring的注解
 */
@Component
public class InnerClass {
	@Component
	class Inner{

	}
}
