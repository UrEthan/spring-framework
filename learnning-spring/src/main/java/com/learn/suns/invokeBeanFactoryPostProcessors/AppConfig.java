package com.learn.suns.invokeBeanFactoryPostProcessors;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.learn.suns.invokeBeanFactoryPostProcessors")
@PropertySource("classpath:app.properties") //配合@Value
//@Import(Bb.class)
//@Import(MyImportSelector.class)
@Import(MyImportBeanDefinitionRegistry.class)
@ImportResource("classpath:spring.xml") //找到对应路径后解析XML 最早的xmlBeanFactory那一套
public class AppConfig {
}
