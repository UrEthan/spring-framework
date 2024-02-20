package com.suns.lesson6;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *  创建BeanDefinition -> 注册bd -> 注册bd的方式有哪些？(1.写XML 2.写注解 @Configuration @Component等衍生注解:Spring工厂遇到这些注解会将对应的类创建bd并注册
 *  3.在配置类使用@Import(User.class) 4.实现ImportSelector接口-@Import(MyImportSelector.class)  )
 *  面向对象编程的三大特性: 封装、继承、多态
 *  1.继承是干什么用？ --> 复用(大错特错),因为采用继承关系的前提是 is a 的关系，并且Java是单继承 若一个子类C想复用 A、B两个类是不行的
 *  2.如果我想采用复用该如何处理？ --> 通过聚合 or 组合的方式完成
 *  --> 让A、B变为C的属性;若考虑到线程安全问题也可以当形参传入
 *  3.继承存在真正的目的是什么？
 *  --> 继承存在不是为了复用,一方面为了满足设计的关系(父子分类等),最重要是为了多态
 *  回到ApplicationContext类如何才能具备Registry功能(注册表、存储bean相关数据)这个问题上，解决方案一个是继承、另一个就是通过聚合 or 组合
 *  --Spring解决方案 -> ApplicationContext包含了DefaultListenableBeanFactory 而不是通过继承Registry
 *  通过查看 AnnotationConfigApplicationContext 类图 推导出 Spring beanFactory 相关类之间的关系
 *
 */
public class Lesson6 {
	public static void main(String[] args) throws Exception {
		/** BeanFactory是lazy创建bean 而ApplicationContext在创建单实例时会预先创建 那么AC底层是如何做到预先创建？
		 *  --> AC容器创建过程中 由AC手动调用了beanFactor.getBean() 然后存储与 singletonObjects 单例池中 (追踪AC创建过程)
		 *  1.流程回顾-> XML文件<bean id="" class=""/> -> 读取xml -> 封装成N个beanDefinition对象 -> 注册到beanDefinitionMap(意味着AC容器必须包含它,否则无处注册bd)
		 *  2.因为AC继承了 GenericApplicationContext 类,而该类包含 DefaultListableBeanFactory 属性,而DefaultBF 又实现了BeanDefinitionRegistry接口行为,故而其需要实现 注册功能
		 *  3.因此 DefaultListableBeanFactory 中包含 beanDefinitionMap,AC可将解析好的BD注册到 DefaultBF 中的 beanDefinitionMap 中
		 *   --- 以上为XML形式,注解其实等价相当于是类上添加了注解@Component 通过类加载的形式解析得到 bd 注册到 beanDefinitionMap
		 *
		 *   BeanDefinitionReader（分为 xml形式 和 Annotated注解形式(未纳入BDReader体系)）如何创建出beanDefinition的？
		 *   --> Annotated注解形式：AnnotatedBeanDefinitionReader 中 doRegisterBean方法 -> 根据需要注册的类直接new出bd
		 *   --> XML形式: XmlBeanDefinitionReader 中 doLoadBeanDefinitions方法 -> processBeanDefinition
		 *   --> 通过编码形式: BeanDefinitionBuilder
		 *   后续开发中往往提供的操作是register但是内部一定包含:
		 *   1.beanDefinition的创建(上述3种方式)
		 *   2.DefaultListableBeanFactory.register(); -> 注册bd到beanDefinitionMap
		 * */
		//初始化AC并解析AppConfig为bd 进行注册 后期会通过配置类提供的信息进行其他bd的注册
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		//在该路径下找有@Component以及衍生注解注释的类 创建bd 并 注册到容器
		AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext("com.suns.lesson6");
		//获取对应的对象
		Object bean = context.getBean("abd");
		System.out.println("----bean----结果=>" + bean);
		//分析一下 注解形式如何让一个类成为beanDefinition
		//BeanDefinition bd = doGetBdByAnnotation();
		//通过编码形式获得bd
		//doGetBdByEnCode();
	}

	private static BeanDefinition doGetBdByAnnotation() {
		//通过类直接封装为beanDefinition
		return new AnnotatedGenericBeanDefinition(Abd.class);
	}

	/**
	 * 如何影响Spring对这个对象的setter注入和构造注入?  通过修改beanDefinition中属性
	 */
	private static BeanDefinition doGetBdByEnCode() {
		//通过编码的形式获取 bd
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(Abd.class);
		GenericBeanDefinition beanDefinition = (GenericBeanDefinition)builder.getBeanDefinition();
		//可以对bd中封装的属性进行修改操作 setter属性的修改
		MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
		propertyValues.add("password","123456");
		//构造参数值修改 在实例化之前可以对bd进行修改
		ConstructorArgumentValues constructorArgumentValues = beanDefinition.getConstructorArgumentValues();
		constructorArgumentValues.addArgumentValues(null);
		return beanDefinition;
	}



}
