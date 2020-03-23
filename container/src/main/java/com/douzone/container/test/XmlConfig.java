package com.douzone.container.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.douzone.container.user.Friend;
import com.douzone.container.user.User;
import com.douzone.container.user.User1;

public class XmlConfig {

	public static void main(String[] args) {
		// XML Auto-Configuration(Annotation Scannig)
		// testApplicationContext01();

		// XML Auto-Configuration(explicit Configuration )
		testApplicationContext02();

		// XML Auto Configuration(Annotation Scanning)
		// testBeanFactory01();

		// XML Bean Configuration(explicit Configuration)
		// testBeanFactory02();

	}

	public static void testApplicationContext01() {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("config/user/applicationContext01.xml");

		User1 user1 = appContext.getBean(User1.class);
		System.out.println(user1.getName());

		// Bean의 id가 자동으로 설정됨
		user1 = (User1) appContext.getBean("user1");
		System.out.println(user1.getName());

		// 자원정리
		((ConfigurableApplicationContext) appContext).close();
	}

	public static void testApplicationContext02() {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("config/user/applicationContext02.xml");

		// id로 bean 가져오기
		User user = (User) appContext.getBean("user");
		System.out.println(user);

		// name으로 bean 가져오기
		user = (User) appContext.getBean("usr");
		System.out.println(user);

		// type으로 가져오기
		// 같은 타입의 객체가 2개 이상 있는경우 type으로만 가져오면 에러
		// ("id",type) 또는 ("name", type) 사용
		user = appContext.getBean("user2", User.class);
		System.out.println(user);
		
		// 2개의 파라미터를 가진 생성자를 사용해 빈 가져오기
		user = appContext.getBean("user3", User.class);
		System.out.println(user);
		
		// 2개의 파라미터를 가진 생성자를 사용해 빈 가져오기 (파라미터의 순서가 반대)
		// index를 지정해주면 가능
		user = appContext.getBean("user4", User.class);
		System.out.println(user);
		
		// setter를 사용한 빈 가져오기
		user = appContext.getBean("user5", User.class);
		System.out.println(user);
		Friend f = appContext.getBean(Friend.class);
		System.out.println(f);
		
		user = appContext.getBean("user6", User.class);
		System.out.println(user);
		
		user = appContext.getBean("user7", User.class);
		System.out.println(user);

		// 자원정리
		((ConfigurableApplicationContext) appContext).close();
	}

	public static void testBeanFactory01() {
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("config/user/applicationContext01.xml"));
		User1 user1 = bf.getBean(User1.class);
		System.out.println(user1.getName());

		// Bean의 id가 자동으로 설정됨
		user1 = (User1) bf.getBean("user1");
		System.out.println(user1.getName());
	}

	public static void testBeanFactory02() {
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("config/user/applicationContext02.xml"));
		User1 user1 = bf.getBean(User1.class);
		System.out.println(user1.getName());

		// Bean의 설정시에는 Bean의 id가 자동으로 설정되지 않음
		// 명시적으로 해야한다.
		user1 = (User1) bf.getBean("user1");
		System.out.println(user1.getName());
	}

}
