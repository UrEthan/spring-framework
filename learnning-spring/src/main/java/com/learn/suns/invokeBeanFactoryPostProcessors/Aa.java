package com.learn.suns.invokeBeanFactoryPostProcessors;

import com.learn.House;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@Component
public class Aa {
	@Value("${product.name}")
	private String name;
}
