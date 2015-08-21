package net.shakaihatsu.training.testing.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import net.shakaihatsu.training.testing.api.MessageProvider;
import net.shakaihatsu.training.testing.util.Dummy;

@Dummy
@Named
@ApplicationScoped
public class DummyMessageProviderImpl implements MessageProvider {

	@Override
	public String provideLuckyCharmMessage(String luckyCharm) {
		return "Your lucky charm is:\n" + luckyCharm;
	}

	public void dummyMethod() {
		System.out.println("Doing nothing!");
	}
}
