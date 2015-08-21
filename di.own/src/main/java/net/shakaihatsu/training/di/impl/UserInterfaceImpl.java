package net.shakaihatsu.training.di.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

import net.shakaihatsu.training.di.api.UserInterface;

public class UserInterfaceImpl implements UserInterface {

	@Override
	public Integer getBase() {
		try {
			Reader reader = new InputStreamReader(System.in);
			BufferedReader bufferedReader = new BufferedReader(reader);
			Integer base = Integer.valueOf(bufferedReader.readLine());

			return base;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void showMessage(String message) {
		System.out.println(message);
	}
}
