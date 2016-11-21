package com.sj;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;
	@Test
	public void contextLoads() {
		final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.sj");
		for (final String beanName : context.getBeanDefinitionNames()) {
			System.out.println(beanName);
		}
		for (final String beanName : applicationContext.getBeanDefinitionNames()) {
			System.out.println(beanName);
		}

	}

}
