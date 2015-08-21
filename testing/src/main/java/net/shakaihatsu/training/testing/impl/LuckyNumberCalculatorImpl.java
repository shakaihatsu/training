package net.shakaihatsu.training.testing.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import net.shakaihatsu.training.testing.api.LuckyNumberCalculator;

@Named
@ApplicationScoped
public class LuckyNumberCalculatorImpl implements LuckyNumberCalculator {
	private static final int LUCKY_NUMBER_MAGIC_NUMBER = 10101;

	@Override
	public Number calculateLuckyNumber(Integer base) {
		return ((Double)(Math.pow(base, 2) * LUCKY_NUMBER_MAGIC_NUMBER)).intValue();
	}

}
