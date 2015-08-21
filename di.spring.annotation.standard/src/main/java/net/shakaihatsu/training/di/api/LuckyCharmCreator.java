package net.shakaihatsu.training.di.api;

import javax.inject.Named;

@Named
public interface LuckyCharmCreator {
	String createLuckyCharm(Number luckyNumber);
}
