package suns.lesson2;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Lesson2 {
	public static void main(String[] args) {
		//Debug查看Spring解析xml标签流程
		XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("application.xml"));
		Product product = (Product) xmlBeanFactory.getBean("p");
		System.out.println("product ------>>>" + product);

	}
}
