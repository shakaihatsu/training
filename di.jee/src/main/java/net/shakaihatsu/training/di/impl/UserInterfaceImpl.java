package net.shakaihatsu.training.di.impl;

import net.shakaihatsu.training.di.api.UserInterface;

public class UserInterfaceImpl implements UserInterface {

	@Override
	public Integer getBase() {
		return 5;
	}

	@Override
	public void showMessage(String message) {
		System.out.println(message);
	}
}
