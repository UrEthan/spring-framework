package com.learn.suns.invokeBeanFactoryPostProcessors;

import com.learn.User;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.function.Predicate;
@Import(User.class) //ImportBeanDefinitionRegistrar不支持在该类上再添加@Import注解
public class MyImportSelector implements ImportSelector {
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{Dd.class.getName(),Ee.class.getName()};
	}

	@Override
	public Predicate<String> getExclusionFilter() {
		return ImportSelector.super.getExclusionFilter();
	}
}
