package net.shakaihatsu.training.di.api;

import javax.inject.Named;

@Named
public interface MessageProvider {
	String provideLuckyCharmMessage(String luckCharm);
}
