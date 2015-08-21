package net.shakaihatsu.training.di.impl;

import net.shakaihatsu.training.di.api.MessageProvider;

import org.springframework.stereotype.Service;

@Service
public class MessageProviderImpl implements MessageProvider {

	@Override
	public String provideLuckyCharmMessage(String luckyCharm) {
		return "Your lucky charm is:\n" + luckyCharm;
	}

}
