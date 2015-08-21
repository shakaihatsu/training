package net.shakaihatsu.training.testing.service;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Named;

import net.shakaihatsu.training.testing.api.LuckyCharmCreator;
import net.shakaihatsu.training.testing.api.LuckyNumberCalculator;
import net.shakaihatsu.training.testing.api.MessageProvider;

@Named
@ApplicationScoped
public class LuckyCharmFacade {
	@Inject
	private LuckyNumberCalculator luckyNumberCalculator;
	@Inject
	private LuckyCharmCreator luckyCharmCreator;
	@Inject @Default
	private MessageProvider messageProvider;

	public String getLuckCharm(Integer base) {
		Number luckyNumber = luckyNumberCalculator.calculateLuckyNumber(base);
		String luckyCharm = luckyCharmCreator.createLuckyCharm(luckyNumber);
		String luckyCharmMessage = messageProvider
				.provideLuckyCharmMessage(luckyCharm);

		return luckyCharmMessage;

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
