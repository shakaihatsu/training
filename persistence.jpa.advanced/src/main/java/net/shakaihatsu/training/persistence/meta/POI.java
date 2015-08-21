package net.shakaihatsu.training.persistence.meta;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface POI {
	String value();
}
