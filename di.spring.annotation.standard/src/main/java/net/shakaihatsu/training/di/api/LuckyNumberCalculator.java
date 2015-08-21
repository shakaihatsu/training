package net.shakaihatsu.training.di.api;

import javax.inject.Named;

@Named
public interface LuckyNumberCalculator {
	Number calculateLuckyNumber(Integer base);
}
