package net.shakaihatsu.training.di.impl;

import net.shakaihatsu.training.di.api.LuckyNumberCalculator;

public class LuckyNumberCalculatorImpl implements LuckyNumberCalculator {

	private static final int LUCKY_NUMBER_MAGIC_NUMBER = 10101;

	@Override
	public Number calculateLuckyNumber(Integer base) {
		return ((Double)(Math.pow(base, 2) * LUCKY_NUMBER_MAGIC_NUMBER)).intValue();
	}

}
