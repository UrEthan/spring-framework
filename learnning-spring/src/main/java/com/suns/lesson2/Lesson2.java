package com.suns.lesson2;


import org.springframework.context.support.ClassPathXmlApplicationContext;


/** TODO 自定义标签
 * 自定义标签的解析过程 --> 例如SpringMVC中<mvc:annotation-driven/>标签就是一个自定义标签 --> 一个标签是如何实现其功能的
 * 1.打开spring-webmvc模块 --> resource --> META-INF(其中spring.handlers、spring.schemas)
 * 2.spring.schemas中有诸多 https\://www.springframework.org/schema/mvc/spring-mvc.xsd=org/springframework/web/servlet/config/spring-mvc.xsd 类似数据其就是配置文件上文件头里面的
 * 3.引入<dependency>
 * 			<groupId>org.springframework</groupId>
 * 			<artifactId>spring-webmvc</artifactId>
 * 			<version>5.2.11.RELEASE</version>
 * 		</dependency> 依赖jar包后
 * 4. 在xml配置文件中使用注解 <mvc:annotation-driven/> --> xml文件中的schemaLocation —> 对应spring.schemas -> spring.handles --> MvcNamespaceHandler
 *  该处理器重载了init方法 该方法中注册了MVC相关的子标签，每个子标签都有一个对应的解析器，例如: registerBeanDefinitionParser("annotation-driven", new AnnotationDrivenBeanDefinitionParser()); 解析器
 *  下面就是AnnotationDrivenBeanDefinitionParser类的静态代码块，其会根据pom文件引入的依赖决定使用gson 或是json 还是fastjson 可自行研究实现过程
 * static {
 * 		ClassLoader classLoader = AnnotationDrivenBeanDefinitionParser.class.getClassLoader();
 * 		javaxValidationPresent = ClassUtils.isPresent("javax.validation.Validator", classLoader);
 * 		romePresent = ClassUtils.isPresent("com.rometools.rome.feed.WireFeed", classLoader);
 * 		jaxb2Present = ClassUtils.isPresent("javax.xml.bind.Binder", classLoader);
 * 		jackson2Present = ClassUtils.isPresent("com.fasterxml.jackson.databind.ObjectMapper", classLoader) &&
 * 						ClassUtils.isPresent("com.fasterxml.jackson.core.JsonGenerator", classLoader);
 * 		jackson2XmlPresent = ClassUtils.isPresent("com.fasterxml.jackson.dataformat.xml.XmlMapper", classLoader);
 * 		jackson2SmilePresent = ClassUtils.isPresent("com.fasterxml.jackson.dataformat.smile.SmileFactory", classLoader);
 * 		jackson2CborPresent = ClassUtils.isPresent("com.fasterxml.jackson.dataformat.cbor.CBORFactory", classLoader);
 * 		gsonPresent = ClassUtils.isPresent("com.google.gson.Gson", classLoader);
 *        }
 * 5.首先要定义 --> user.xsd 用于约束自定义 user标签  在schema中写 https\://www.suns.com/schema/user.xsd=META-INF/user.xsd 意味着通过key能找到META-INF中的user.xsd约束规范
 * 6.首先要在application.xml中去定义xml的name-space 其中冒号之后就是其头的名称 xmlns:aop="http://www.springframework.org/schema/aop" 此处定义了aop那么注解也要写<aop/>
 * 7.添加自定义的的命名空间 xmlns:suns="http://www.suns.com/schema/user"
 * 8.在配置文件中加了命名空间即可使用自定义标签 <suns:user id="1" name="zhu" password="123"/>
 * 9.在xml文件头中的 schemaLocation 里先后添加 http://www.suns.com/schema/user  https://www.suns.com/schema/user.xsd 找到--> spring.schemas（https\://www.suns.com/schema/user.xsd=META-INF/user.xsd） 最终找到user.xsd
 * 10.究其根本就是命名空间中的 xmlns:suns="http://www.suns.com/schema/user" 关联 schemaLocation中的 http://www.suns.com/schema/use ->关联出 https://www.suns.com/schema/user.xsd -> 关联出真正的物理路径 META-INF/user.xsd
 * 11.所有的标签最需要进行解析故user.xsd中的 targetNamespace="http://www.suns.com/schema/user" 会在spring.handlers中找到 https\://www.suns.com/schema/user=com.suns.lesson2.MyNameSpaceHandler
 * 12.在MyNameSpaceHandler中注册 user标签的解析器 UserBeanDefinitionParser 并且实先 解析器的方法
 */
public class Lesson2 {
	public static void main(String[] args) {
		//Debug查看Spring解析xml标签流程
		//查看suns命名空间下的 子标签 user 是否生效
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("application.xml");
		User user = (User) classPathXmlApplicationContext.getBean("suns");
		System.out.println("user.name ------>>>" + user.getName());
		System.out.println("user.password ------>>>" + user.getPassword());

	}
}
