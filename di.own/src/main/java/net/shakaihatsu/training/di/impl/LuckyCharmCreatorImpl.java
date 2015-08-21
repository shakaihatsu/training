package net.shakaihatsu.training.di.impl;

import net.shakaihatsu.training.di.api.LuckyCharmCreator;

public class LuckyCharmCreatorImpl implements LuckyCharmCreator {
	private static final String LUCKY_CHARM_LEFT_SIDE = "*** ";

	@Override
	public String createLuckyCharm(Number luckyNumber) {
		return LUCKY_CHARM_LEFT_SIDE + luckyNumber + createRightSide();
	}

	private String createRightSide() {
		return new StringBuilder(LUCKY_CHARM_LEFT_SIDE).reverse().toString();
	}

}
