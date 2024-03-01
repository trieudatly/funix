package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		//TennisCoach tennisCoach=context.getBean(TennisCoach.class);
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SportConfig.class);
Coach theCoach=context.getBean("tennisCoach",Coach.class);
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		//context.getBeanFactory().destroyBean(theCoach);
context.close();
	}

}
