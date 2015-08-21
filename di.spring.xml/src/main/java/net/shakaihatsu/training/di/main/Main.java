package net.shakaihatsu.training.di.main;

import net.shakaihatsu.training.di.api.LuckyCharmCreator;
import net.shakaihatsu.training.di.api.LuckyNumberCalculator;
import net.shakaihatsu.training.di.api.MessageProvider;
import net.shakaihatsu.training.di.api.UserInterface;
import net.shakaihatsu.training.di.app.App;
import net.shakaihatsu.training.di.impl.LuckyCharmCreatorImpl;
import net.shakaihatsu.training.di.impl.LuckyNumberCalculatorImpl;
import net.shakaihatsu.training.di.impl.MessageProviderImpl;
import net.shakaihatsu.training.di.impl.UserInterfaceImpl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/applicationContext.xml");
		
		App app = context.getBean(App.class);
		app.run();
	}
}
