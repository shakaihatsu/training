package net.shakaihatsu.training.persistence.domain.vehicle;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import net.shakaihatsu.training.persistence.domain.common.PersistentEntity;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Vehicle extends PersistentEntity {
	private String name;
	private Long speedInKmh;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSpeedInKmh() {
		return speedInKmh;
	}

	public void setSpeedInKmh(Long speedInKmh) {
		this.speedInKmh = speedInKmh;
	}
}