package com.suns.lesson6;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.suns.lesson6")
//@Import(User.class) 方式一
//@Import(MyImportSelector.class) //方式二 可批量导入
//@Import(MyBdImportRegister.class)
@MySpringApplication //使用自定义注解封装细节(这也是SpringBoot自动注解的核心实现思路)
public class AppConfig {
}
