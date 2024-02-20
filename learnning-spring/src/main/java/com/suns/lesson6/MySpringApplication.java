package com.suns.lesson6;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 模仿SpringBoot启动注解实现:
 * 通过自定义注解封装 @Import(MyImportSelector.class) 防止内部细节暴露 对外只提供一个 自定义注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Import(MyImportSelector.class) //引入注册类
public @interface MySpringApplication {
}
