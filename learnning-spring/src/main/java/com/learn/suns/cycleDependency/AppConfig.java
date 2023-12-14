package com.learn.suns.cycleDependency;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.learn.suns.cycleDependency")
@EnableAspectJAutoProxy
public class AppConfig {
}
