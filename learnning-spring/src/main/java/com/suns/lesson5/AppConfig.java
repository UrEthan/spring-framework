package com.suns.lesson5;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.suns.lesson5")
@EnableAspectJAutoProxy //开启做代理
public class AppConfig {
}
