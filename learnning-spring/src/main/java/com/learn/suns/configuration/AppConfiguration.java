package com.learn.suns.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration等价与@Component注解 user是AppConfiguration的一个方法获取getBean("user")
 */
@Configuration
public class AppConfiguration {
	@Bean //创建代理可以为@Configuration注解中的方法增加@Scope相关的额外功能
	public User user(){
		return new User();
	}
}
