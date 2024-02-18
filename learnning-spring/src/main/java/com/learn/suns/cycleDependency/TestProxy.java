package com.learn.suns.cycleDependency;

import com.suns.lesson2.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试两个类都需创建代理对象情况下的 循环依赖
 */
public class TestProxy {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		A a = (A)context.getBean("a");
		B b = (B)context.getBean("b");
		a.showB();
		b.showA();


		List<User> userList = new ArrayList<>();
		User u = null;
		for (User user : userList) {
			if (user.getName().equals("default")){
				u = user;
			}

		}
	}
	/*public static void main(String[] args) {
		//User user = new User();
		String aaa = new String("aaa");
		int a =8;
		change(a);
		System.out.println("---------------"+a);
	}
	AI集成
	识别率提升、性能优化

	private static void change(int a){
		User user1 = new User();
		user1.setName("niubi");
		String bb = new String("bb");
		a = 10;
	}*/


}
