package net.shakaihatsu.training.testing.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import net.shakaihatsu.training.testing.api.LuckyCharmCreator;

@Named
@ApplicationScoped
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
