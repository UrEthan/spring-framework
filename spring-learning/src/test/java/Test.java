import com.ethan.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext acx = new ClassPathXmlApplicationContext("spring-config.xml");
		User user = acx.getBean("user",User.class);
		System.out.println(user.getName()+user.getAge());
	}
}
