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

public class Main {
	public static void main(String[] args) {
		UserInterface userInterface = new UserInterfaceImpl();
		MessageProvider messageProvider = new MessageProviderImpl();
		LuckyCharmCreator luckyCharmCreator = new LuckyCharmCreatorImpl();
		LuckyNumberCalculator luckyNumberCalculator = new LuckyNumberCalculatorImpl();

		App app = new App();
		app.setUserInterface(userInterface);
		app.setMessageProvider(messageProvider);
		app.setLuckyCharmCreator(luckyCharmCreator);
		app.setLuckyNumberCalculator(luckyNumberCalculator);
		
		app.run();
	}
}
