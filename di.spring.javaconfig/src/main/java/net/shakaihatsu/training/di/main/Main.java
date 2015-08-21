package net.shakaihatsu.training.di.main;

import net.shakaihatsu.training.di.app.App;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext("net.shakaihatsu.training");
		
		App app = context.getBean(App.class);
		app.run();
	}
}
