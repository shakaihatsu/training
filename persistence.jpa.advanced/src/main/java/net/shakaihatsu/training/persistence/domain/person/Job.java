package net.shakaihatsu.training.persistence.domain.person;

import javax.persistence.Entity;

import net.shakaihatsu.training.persistence.domain.common.PersistentEntity;

@Entity
public class Job extends PersistentEntity {
	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
