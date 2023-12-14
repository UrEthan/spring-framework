package com.learn.suns.invokeBeanFactoryPostProcessors;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

//@Component //还需要添加这个注解才可以aop
@EnableAspectJAutoProxy //但凡Enable开头的注解底层都是通过@Import引入一个类，进行实现
public class Bb {
}
