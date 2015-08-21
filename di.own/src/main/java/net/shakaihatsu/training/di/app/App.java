package net.shakaihatsu.training.di.app;

import net.shakaihatsu.training.di.api.LuckyCharmCreator;
import net.shakaihatsu.training.di.api.LuckyNumberCalculator;
import net.shakaihatsu.training.di.api.MessageProvider;
import net.shakaihatsu.training.di.api.UserInterface;

public class App {
	private UserInterface userInterface;
	private LuckyNumberCalculator luckyNumberCalculator;
	private LuckyCharmCreator luckyCharmCreator;
	private MessageProvider messageProvider;
	
	public void run() {
		Integer base = userInterface.getBase();
		Number luckyNumber = luckyNumberCalculator.calculateLuckyNumber(base);
		String luckyCharm = luckyCharmCreator.createLuckyCharm(luckyNumber);
		String luckyCharmMessage = messageProvider.provideLuckyCharmMessage(luckyCharm);
		userInterface.showMessage(luckyCharmMessage);
	}
	
	public void setUserInterface(UserInterface userInterface) {
		this.userInterface = userInterface;
	}
	
	public void setLuckyNumberCalculator(
			LuckyNumberCalculator luckyNumberCalculator) {
		this.luckyNumberCalculator = luckyNumberCalculator;
	}

	public void setLuckyCharmCreator(LuckyCharmCreator luckyCharmCreator) {
		this.luckyCharmCreator = luckyCharmCreator;
	}
	
	public void setMessageProvider(MessageProvider messageProvider) {
		this.messageProvider = messageProvider;
	}
}
