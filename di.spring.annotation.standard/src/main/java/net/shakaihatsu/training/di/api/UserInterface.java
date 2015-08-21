package net.shakaihatsu.training.di.api;

import javax.inject.Named;

@Named
public interface UserInterface {
	Integer getBase();
	void showMessage(String message);
}
