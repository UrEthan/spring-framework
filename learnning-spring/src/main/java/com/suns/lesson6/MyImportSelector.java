package com.suns.lesson6;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/** 99%使用
 * 选择条件:存在实际的类型->能看到其.Class文件 时选择他ImportSelector ｜ 一般伴随SPI机制；如果不存在实际的.class,需要动态字节码技术运行创建的类型
 * 除了在配置类使用 @Import(User.class) 注册普通类以外 还可以通过实现 ImportSelector 完成普通类的注册
 * TODO: 这种方式不常用,在封装的时候使用,可以不向最终用户暴露细节
 */
public class MyImportSelector implements ImportSelector {
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		//获得普通类User的全限定名,作为这个方法的结果返回 Spring就可以加载到该类;此处为数组-> 可以批量导入
		return new String[]{User.class.getName()};
	}
}
