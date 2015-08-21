package net.shakaihatsu.training.di.impl;

import net.shakaihatsu.training.di.api.MessageProvider;

public class MessageProviderImpl implements MessageProvider {

	@Override
	public String provideLuckyCharmMessage(String luckyCharm) {
		return "Your lucky charm is:\n" + luckyCharm;
	}

}
