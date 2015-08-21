package net.shakaihatsu.training.di.main;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import net.shakaihatsu.training.di.app.App;

@Startup
@Singleton
public class Main {
	@Inject
	private App app;
	
	@PostConstruct
	public void setUp() {
		app.run();
	}
}
