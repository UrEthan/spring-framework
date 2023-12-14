package com.learn.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.learn.annotation")
@PropertySource("classpath:app.properties")
public class AppConfig {
}
