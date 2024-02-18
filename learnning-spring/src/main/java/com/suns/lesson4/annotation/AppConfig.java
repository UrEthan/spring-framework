package com.suns.lesson4.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.suns.lesson4.annotation")
@PropertySource("classpath:app.properties")
public class AppConfig {
}
