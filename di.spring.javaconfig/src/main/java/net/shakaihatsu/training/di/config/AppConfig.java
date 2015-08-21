package net.shakaihatsu.training.di.config;

import net.shakaihatsu.training.di.api.LuckyCharmCreator;
import net.shakaihatsu.training.di.api.LuckyNumberCalculator;
import net.shakaihatsu.training.di.api.MessageProvider;
import net.shakaihatsu.training.di.api.UserInterface;
import net.shakaihatsu.training.di.app.App;
import net.shakaihatsu.training.di.impl.LuckyCharmCreatorImpl;
import net.shakaihatsu.training.di.impl.LuckyNumberCalculatorImpl;
import net.shakaihatsu.training.di.impl.MessageProviderImpl;
import net.shakaihatsu.training.di.impl.UserInterfaceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean
	public App app() {
		App app = new App();

		// app.setLuckyNumberCalculator(luckyNumberCalculator());
		// app.setUserInterface(userInterface());
		app.setLuckyCharmCreator(luckyCharmCreator());
		app.setMessageProvider(messageProvider());

		return app;
	}

	@Bean
	public LuckyCharmCreator luckyCharmCreator() {
		return new LuckyCharmCreatorImpl();
	}

	@Bean
	public LuckyNumberCalculator luckyNumberCalculator() {
		return new LuckyNumberCalculatorImpl();
	}

	@Bean
	public MessageProvider messageProvider() {
		return new MessageProviderImpl();
	}

	@Bean
	public UserInterface userInterface() {
		return new UserInterfaceImpl();
	}
}