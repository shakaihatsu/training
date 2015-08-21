package net.shakaihatsu.training.testing.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Named;

import net.shakaihatsu.training.testing.api.MessageProvider;

@Default
@Named
@ApplicationScoped
public class MessageProviderImpl implements MessageProvider {

	@Override
	public String provideLuckyCharmMessage(String luckyCharm) {
		return "Your lucky charm is:\n" + luckyCharm;
	}

}
