package com.learn.suns.mybatis;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.learn.suns.mybatis")
@Import(MyImportRegister.class)
public class AppConfig {
}
