package net.shakaihatsu.training.di.app;

import net.shakaihatsu.training.di.api.LuckyCharmCreator;
import net.shakaihatsu.training.di.api.LuckyNumberCalculator;
import net.shakaihatsu.training.di.api.MessageProvider;
import net.shakaihatsu.training.di.api.UserInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class App {
	@Autowired
	private UserInterface userInterface;
	@Autowired
	private LuckyNumberCalculator luckyNumberCalculator;
	@Autowired
	private LuckyCharmCreator luckyCharmCreator;
	@Autowired
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
