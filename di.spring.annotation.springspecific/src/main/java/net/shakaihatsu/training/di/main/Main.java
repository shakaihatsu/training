package net.shakaihatsu.training.di.main;

import net.shakaihatsu.training.di.app.App;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/applicationContext.xml");
		
		App app = context.getBean(App.class);
		app.run();
	}
}
